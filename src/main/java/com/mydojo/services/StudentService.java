package com.mydojo.services;

import com.mydojo.dtos.StudentDto;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    @Transactional
    List<String> addStudent(StudentDto studentDto);

    List<String> studentLogin(StudentDto studentDto);

    List<StudentDto> getStudentList();

    Optional<StudentDto> getStudentById(Long studentId);
}
