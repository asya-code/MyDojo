package com.mydojo.services;

import com.mydojo.dtos.TournamentDto;
import com.mydojo.entites.Coach;
import com.mydojo.entites.Student;
import com.mydojo.entites.Tournament;
import com.mydojo.repositories.CoachRepository;
import com.mydojo.repositories.StudentRepository;
import com.mydojo.repositories.TournamentRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class TournamentServiceImpl implements TournamentService {
    @Autowired
    private TournamentRepository tournamentRepository;

    @Autowired
    private CoachRepository coachRepository;

    @Autowired
    private StudentRepository studentRepository;


    @Override
    @Transactional
    public List<String> addNewTournament(TournamentDto tournamentDto) {
        List<String> response = new ArrayList<>();
       Tournament tournament = new Tournament(tournamentDto);
        tournamentRepository.saveAndFlush(tournament);
        System.out.println(tournament);
        response.add("Tournament Added Successfully");
        return response;
    }

    @Override
    @Transactional
    public void deleteTournamentByIdCoach(Long tournamentId){
        Optional<Tournament> tournamentOptional = tournamentRepository.findById(tournamentId);
        tournamentOptional.ifPresent((tournament -> tournamentRepository.delete(tournament)));
    }

    @Override
    @Transactional
    public void updateTournament(TournamentDto tournamentDto) {
        Optional<Tournament> tournamentOptional = tournamentRepository.findById(tournamentDto.getTournamentId());
        tournamentOptional.ifPresent((tournament -> {
            tournament.setTournamentName(tournamentDto.getTournamentName());
            tournament.setArt(tournament.getArt());
            tournament.setDate((Date) tournamentDto.getDate());
            tournament.setTime(tournamentDto.getTime());
            tournament.setAge(tournament.getAge());
            tournament.setDescription(tournament.getDescription());
//            tournament.setCoachSet(tournamentDto.getCoachSet());
//            tournament.setStudentSet(tournamentDto.getStudentSet());
            tournamentRepository.saveAndFlush(tournament);
        }));
    }

    @Transactional
    @Override
    public void addCoachToTournamentSet(Long tournamentId, Long coachId) {
        Optional<Tournament> tournamentOptional = tournamentRepository.findById(tournamentId);
        if (!tournamentOptional.isPresent()) {
            System.out.println("addCoachToSet tournament not found: " + tournamentId);
            return;
        }

        Optional<Coach> coachOptional = coachRepository.findById(coachId);
        if (!coachOptional.isPresent()) {
            System.out.println("addCoachToSet coach not found: " + coachId);
            return;
        }

        Tournament tournament = tournamentOptional.get();
        tournament.getCoachSet().add(coachOptional.get());
        coachOptional.get().getTournamentSet().add(tournament);
        tournamentRepository.saveAndFlush(tournament);
    }

    @Override
    public List<TournamentDto> getAllTournamentByCoach(Long coachId) {
        Optional<Coach> coachOptional = coachRepository.findById(coachId);
        if (coachOptional.isPresent()) {
            List<Tournament> tournamentList = tournamentRepository.findByCoachSet_CoachId(coachOptional.get().getCoachId());
            return tournamentList.stream().map(tournament -> new TournamentDto(tournament)).collect(Collectors.toList());
        }
        return Collections.emptyList();
    }

    @Override
    public List<TournamentDto> getAllTournamentByStudent(Long studentId) {
        Optional<Student> studentOptional = studentRepository.findById(studentId);
        if (studentOptional.isPresent()) {
            List<Tournament> tournamentList = tournamentRepository.findByStudentSet_StudentId(studentOptional.get().getStudentId());
            return tournamentList.stream().map(tournament -> new TournamentDto(tournament)).collect(Collectors.toList());
        }
        return Collections.emptyList();
    }

    @Override
    public Optional<TournamentDto> getTournamentById(Long tournamentId) {
        Optional<Tournament> tournamentOptional = tournamentRepository.findById(tournamentId);
        if (tournamentOptional.isPresent()) {
            return Optional.of(new TournamentDto((tournamentOptional.get())));
        }
        return Optional.empty();
    }

    @Override
    public List<TournamentDto> getTournamentList() {
        return tournamentRepository.findAll().stream().map(entity -> {
            return new TournamentDto(entity);
        }).toList();
    }

    @Override
    public void addStudentToTournamentSet(Long tournamentId, Long studentId) {
        Optional<Tournament> tournamentOptional = tournamentRepository.findById(tournamentId);
        if (!tournamentOptional.isPresent()) {
            System.out.println("addStudentToTournamentSet tournament not found: " + tournamentId);
            return;
        }

        Optional<Student> studentOptional = studentRepository.findById(studentId);
        if (!studentOptional.isPresent()) {
            System.out.println("addStudentToTournamentSet student not found: " + studentId);
            return;
        }

        Tournament tournament = tournamentOptional.get();
        tournament.getStudentSet().add(studentOptional.get());
        studentOptional.get().getTournamentSet().add(tournament);
        tournamentRepository.saveAndFlush(tournament);
    }
}
