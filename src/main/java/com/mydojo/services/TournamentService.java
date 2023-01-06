package com.mydojo.services;

import com.mydojo.dtos.TournamentDto;
import jakarta.transaction.Transactional;

import java.util.List;

public interface TournamentService {
    @Transactional
    void createTournament(TournamentDto tournamentDto, Long coachId);

    @Transactional
    void deleteTournamentByIdCoach(Long tournamentId);

    @Transactional
    void updateTournamentByCoach(TournamentDto tournamentDto);

    List<TournamentDto> getAllTournamentsByCoach(Long coachId);

    List<TournamentDto> getAllTournamentByStudent(Long studentId);
}
