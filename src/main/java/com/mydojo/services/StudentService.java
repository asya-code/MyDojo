package com.mydojo.services;

import com.mydojo.dtos.StudentDto;
import jakarta.transaction.Transactional;

import java.util.List;

public interface StudentService {
    @Transactional
    List<String> addStudent(StudentDto studentDto);

    List<String> studentLogin(StudentDto studentDto);
}
