package com.mydojo.controllers;

import com.mydojo.dtos.UserDto;
import com.mydojo.services.CoachService;
import com.mydojo.services.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private CoachService coachService;
    @Autowired
    private LoginHelper loginHelper;

    @PostMapping("/registerAdmin")
    public List<String> registerAdmin(@RequestBody UserDto userDto) {
        System.out.println(userDto.toString());

        Optional<UserDto> user = userService.findByEmail(userDto.getEmail());
        if (!user.isPresent()) {
            userService.addByEmail(userDto.getEmail(), userDto.getPassword());
            user = userService.findByEmail(userDto.getEmail());
            if (!user.isPresent()) {
                throw new RuntimeException("New user not found");
            }
        }

        user.get().setIsAdmin(true);
        userService.update(userDto);
        return new ArrayList<>();
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(HttpSession session,
                                   @RequestBody UserDto userDto) {
        Optional<UserDto> user = userService.login(userDto.getEmail(), userDto.getPassword());
        if (!user.isPresent()) {
            return loginHelper.createLoginRedirect();
        }

        session.setAttribute("signed_user", userDto.getEmail());
        session.setAttribute("is_admin", Boolean.valueOf(userService.isAdmin(userDto.getEmail())));
        session.setAttribute("is_coach", Boolean.valueOf(coachService.isCoach(userDto.getEmail())));

        HttpHeaders responseHeaders = new HttpHeaders();
        return new ResponseEntity<>(
                "{ \"status\": \"logged_in\" }", responseHeaders, HttpStatus.OK);
    }

    @GetMapping("/all")
    public List<UserDto> getAll() {
        return userService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<UserDto> findById(@PathVariable Long id){
       return userService.findById(id);
    }

    @GetMapping("/{email}")
    public Optional<UserDto> findByEmail(@PathVariable String email){
        return userService.findByEmail(email);
    }

    @PostMapping("/registerUser")
    public void registerUser(@RequestBody com.mydojo.dtos.UserDto userDto){
        userService.addByEmail(userDto.getEmail(), userDto.getPassword());
    }
}
