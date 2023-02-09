package com.mydojo.controllers;

import com.mydojo.dtos.CoachDto;
import com.mydojo.repositories.CoachRepository;
import com.mydojo.services.CoachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;


import java.util.List;
import java.util.Optional;

//@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/api/coaches")
public class CoachController {
    @Autowired
    private CoachService coachService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private CoachRepository coachRepository;

    @PostMapping("/registerCoach")
    public List<String> addCoach(@RequestBody CoachDto coachDto) {
        System.out.println(coachDto.toString());
        String passHash = passwordEncoder.encode(coachDto.getPassword());
        coachDto.setPassword(passHash);
        return coachService.addCoach(coachDto);
    }

    @PostMapping("/login")
    public List<String> coachLogin(@RequestBody CoachDto coachDto) {
        return coachService.coachLogin(coachDto);
    }

    @GetMapping("")
    public List<CoachDto> getAllCoaches() {
        return coachService.getCoachList();
    }

    @GetMapping("/{coachId}")
    public Optional <CoachDto> getCoachById(@PathVariable Long coachId){
       return coachService.getCoachById(coachId);
    }

    // do I need this?
//    @GetMapping("/{coachId}/my-profile")
//    public Optional<CoachDto>

}











