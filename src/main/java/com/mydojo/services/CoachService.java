package com.mydojo.services;

import com.mydojo.dtos.CoachDto;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

public interface CoachService {
    @Transactional
    List<String> addCoach(CoachDto coachDto);

    @Transactional
    void updateCoach(CoachDto coachDto);

    List<CoachDto> getCoachList();

    Optional<CoachDto> getCoachById(Long coachId);

    boolean isCoach(String email);
}
