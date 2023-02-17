package com.mydojo.services;

import com.mydojo.dtos.CoachDto;
import com.mydojo.dtos.StudentDto;
import com.mydojo.dtos.TournamentDto;
import com.mydojo.entites.Tournament;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

public interface TournamentService {
    @Transactional
    List<String> addNewTournament(TournamentDto tournamentDto);

    @Transactional
    void deleteTournamentByIdCoach(Long tournamentId);

    @Transactional
    void updateTournament(Long tournamentId, TournamentDto tournamentDto);

    @Transactional
    void addCoachToTournamentSet(Long tournamentId, Long coachId);

    List<TournamentDto> getAllTournamentByCoach(Long coachId);

    List<TournamentDto> getAllTournamentByStudent(Long studentId);

    Optional<TournamentDto> getTournamentById(Long tournamentId);

    List<StudentDto> getStudentListByTournamentId(Long tournamentId);

    void deleteStudentFromTournament(Long tournamentId, Long studentId);

    List<CoachDto> getCoachListByTournamentId(Long tournamentId);

    void deleteCoachFromTournament(Long tournamentId, Long coachId);

    List<TournamentDto> getTournamentList();

    void addStudentToTournamentSet(Long tournamentId, Long studentId);
}
