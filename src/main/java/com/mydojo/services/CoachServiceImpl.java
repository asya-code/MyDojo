package com.mydojo.services;

import com.mydojo.dtos.CoachDto;
import com.mydojo.entites.Coach;
import com.mydojo.repositories.CoachRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CoachServiceImpl implements CoachService {
    @Autowired
    private CoachRepository coachRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public List<String> addCoach(CoachDto coachDto) {
        List<String> response = new ArrayList<>();
        Coach coach = new Coach(coachDto);
        coachRepository.saveAndFlush(coach);
        response.add("Coach Added Successfully");
        return response;
    }

    @Override
    public List<String> coachLogin(CoachDto coachDto) {
        List<String> response = new ArrayList<>();
        Optional<Coach> coachOptional = coachRepository.findByEmail(coachDto.getEmail());
            if (coachOptional.isPresent()) {
                if (passwordEncoder.matches(coachDto.getPassword(), coachOptional.get().getPassword())) {
                    response.add("Coach login successful");
                    response.add(String.valueOf(coachOptional.get().getCoachId()));
                } else {
                    response.add("Email or password is incorrect");
                }
            } else {
                response.add("Email or password is incorrect");
            }
            return response;
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
}
