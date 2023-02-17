package com.mydojo.controllers;

import com.mydojo.dtos.CoachDto;
import com.mydojo.dtos.UserDto;
import com.mydojo.repositories.CoachRepository;
import com.mydojo.services.CoachService;
import com.mydojo.services.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/api/coaches")
public class CoachController {
    @Autowired
    private CoachService coachService;
    @Autowired
    private CoachRepository coachRepository;
    @Autowired
    private UserService userService;
    @Autowired
    private LoginHelper loginHelper;

    @PostMapping("/registerCoach")
    public List<String> registerCoach(@RequestBody CoachDto coachDto) {
        System.out.println(coachDto.toString());

        Optional<UserDto> user = userService.findByEmail(coachDto.getEmail());
        if (!user.isPresent()) {
            userService.addByEmail(coachDto.getEmail(), coachDto.getPassword());
            user = userService.findByEmail(coachDto.getEmail());
            if (!user.isPresent()) {
                throw new RuntimeException("New user not found");
            }
        }

        return coachService.addCoach(coachDto);
    }

    @GetMapping("/all")
    public List<CoachDto> getCoachList(){
        return coachService.getCoachList();
    }
// secured option
//    @GetMapping("/all")
//    public ResponseEntity<?> getAll(HttpSession session) throws Exception {
//        String loggedInUser = loginHelper.getLoggedInUser(session);
//        if (loggedInUser == null) {
//            return loginHelper.createLoginRedirect();
//        }
//        if (loginHelper.isUserAdminOrCoach(session)) {
//            List<CoachDto> coaches = coachService.getCoachList();
//            return loginHelper.createResponse(coaches);
//        }
//        return loginHelper.createUnauthorizedResponse();
//    }

    @GetMapping("/id/{coachId}")
    public Optional<CoachDto> getCoachById(@PathVariable Long coachId){
       return coachService.getCoachById(coachId);
    }

    @PutMapping("/id/{coachId}")
    public void updateCoach(@PathVariable Long coachId,
                             @RequestBody CoachDto coachDto) {
        coachService.updateCoach(coachId, coachDto);
    }
}
