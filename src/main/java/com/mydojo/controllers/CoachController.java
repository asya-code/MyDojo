package com.mydojo.controllers;

import com.mydojo.dtos.CoachDto;
import com.mydojo.services.CoachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/coaches")
public class CoachController {
    @Autowired
    private CoachService coachService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/registerCoach")
    public List<String> addCoach(@RequestBody CoachDto coachDto) {
        String passHash = passwordEncoder.encode(coachDto.getPassword());
        coachDto.setPassword(passHash);
        return coachService.addCoach(coachDto);
    }

    @PostMapping("")
}











