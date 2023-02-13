package com.mydojo.services;

import com.mydojo.dtos.UserDto;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

public interface UserService {
    @Transactional
    List<String> add(UserDto user);

    @Transactional
    List<String> addByEmail(String email, String password);

    @Transactional
    void update(UserDto user);

    Optional<UserDto> login(String email, String password);

    List<UserDto> getAll();

    Optional<UserDto> findById(Long id);

    Optional<UserDto> findByEmail(String email);

    boolean isAdmin(String email);
}
