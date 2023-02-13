package com.mydojo.services;

import com.mydojo.dtos.UserDto;
import com.mydojo.entites.User;
import com.mydojo.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

//    @Autowired
//    private PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public List<String> add(UserDto userDto) {
        List<String> response = new ArrayList<>();
        User user = new User(userDto);
//        String passHash = passwordEncoder.encode(user.getPassword());
//        user.setPassword(passHash);
        userRepository.saveAndFlush(user);
        response.add("user added successfully");
        return response;
    }

    @Override
    @Transactional
    public List<String> addByEmail(String email, String password) {
        List<String> response = new ArrayList<>();
        User user = new User();
        user.setEmail(email);
//        String passHash = passwordEncoder.encode(password);
//        user.setPassword(passHash);
        user.setPassword(password);
        userRepository.saveAndFlush(user);
        response.add("user added successfully");
        return response;
    }

    @Override
    @Transactional
    public void update(UserDto userDto) {
        Optional<User> userOptional = userRepository.findById(userDto.getId());
        userOptional.ifPresent(user -> {
            user.setEmail(userDto.getEmail());
            user.setPassword(userDto.getPassword());
            userRepository.saveAndFlush(user);
        });
    }

    @Override
    public Optional<UserDto> login(String email, String password) {
        Optional<User> userOptional = userRepository.findByEmail(email);
        if (userOptional.isPresent()) {
            if (password.equals(userOptional.get().getPassword())) {
//            if (passwordEncoder.matches(password,
//                    userOptional.get().getPassword())) {
//                response.add("http://localhost:8080/index.html");
//                response.add(String.valueOf(userOptional.get().getId()));
                return Optional.of(new UserDto(userOptional.get()));
            }
        }
        return Optional.empty();
    }

    @Override
    public List<UserDto> getAll() {
        return userRepository.findAll().stream().map(entity -> {
            return new UserDto(entity);
        }).toList();
    }

    @Override
    public Optional<UserDto> findById(Long id) {
        Optional<User> optional = userRepository.findById(id);
        if (optional.isPresent()) {
            return Optional.of(new UserDto(optional.get()));
        }
        return Optional.empty();
    }

    @Override
    public Optional<UserDto> findByEmail(String email) {
        Optional<User> optional = userRepository.findByEmail(email);
        if (optional.isPresent()) {
            return Optional.of(new UserDto(optional.get()));
        }
        return Optional.empty();
    }

    @Override
    public boolean isAdmin(String email) {
        Optional<User> optional = userRepository.findByEmail(email);
        if (optional.isPresent()) {
            Boolean result = optional.get().getIsAdmin();
            return (result != null ? result : false);
        }
        return false;
    }
}
