package com.mydojo.services;

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
    void updateTournament(TournamentDto tournamentDto);

    @Transactional
    void addCoachToTournamentSet(Long tournamentId, Long coachId);

    List<TournamentDto> getAllTournamentByCoach(Long coachId);

    List<TournamentDto> getAllTournamentByStudent(Long studentId);

    Optional<TournamentDto> getTournamentById(Long tournamentId);

    List<TournamentDto> getTournamentList();

    void addStudentToTournamentSet(Long tournamentId, Long studentId);

}
