package com.mydojo.services;

import com.mydojo.dtos.CoachDto;
import com.mydojo.entites.Coach;
import com.mydojo.entites.User;
import com.mydojo.repositories.CoachRepository;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CoachServiceImpl implements CoachService {
    @Autowired
    private CoachRepository coachRepository;

    @Override
    @Transactional
    public List<String> addCoach(CoachDto coachDto) {
        List<String> response = new ArrayList<>();
        Coach coach = new Coach(coachDto);
        coachRepository.saveAndFlush(coach);
        response.add("coach added successfully");
        return response;
    }

    @Override
    @Transactional
    public void updateCoach(Long coachId, CoachDto coachDto){
        Optional<Coach> coachOptional = coachRepository.findById(coachId);
        coachOptional.ifPresent(coach -> {
            coach.setFirstName(coachDto.getFirstName());
            coach.setLastName(coachDto.getLastName());
            coach.setMiddleName(coachDto.getMiddleName());
            coach.setDob(coachDto.getDob());
            coach.setEmail(coachDto.getEmail());
            coach.setImage(coachDto.getImage());
            coach.setTeachingSince(coachDto.getTeachingSince());
            coach.setRank(coachDto.getRank());
            coach.setDescription(coachDto.getDescription());
            coachRepository.saveAndFlush(coach);
        });
    }

    @Override
    public List<CoachDto> getCoachList(){
        return coachRepository.findAll().stream().map(entity -> {
            return new CoachDto(entity);
        }).toList();
    }

    @Override
    public Optional<CoachDto> getCoachById(Long coachId) {
        Optional<Coach> coachOptional = coachRepository.findById(coachId);
        if (coachOptional.isPresent()) {
            return Optional.of(new CoachDto(coachOptional.get()));
        }
        return Optional.empty();
    }

    @Override
    public boolean isCoach(String email) {
        Optional<Coach> optional = coachRepository.findByEmail(email);
        return optional.isPresent();
    }
}
