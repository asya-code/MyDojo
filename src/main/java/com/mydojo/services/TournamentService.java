package com.mydojo.services;

import com.mydojo.dtos.TournamentDto;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

public interface TournamentService {
    @Transactional
    List<String> addNewTournament(TournamentDto tournamentDto, Long coachId);

    @Transactional
    void deleteTournamentByIdCoach(Long tournamentId);

    @Transactional
    void updateTournamentByCoach(TournamentDto tournamentDto);

    List<TournamentDto> getAllTournamentByCoach(Long coachId);

    List<TournamentDto> getAllTournamentByStudent(Long studentId);

    Optional<TournamentDto> getTournamentById(Long tournamentId);

    List<TournamentDto> getTournamentList();
}
