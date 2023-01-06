package com.mydojo.services;

import com.mydojo.dtos.CoachDto;
import jakarta.transaction.Transactional;

import java.util.List;

public interface CoachService {
    @Transactional
    List<String> addCoach(CoachDto coachDto);

    List<String> coachLogin(CoachDto coachDto);
}
