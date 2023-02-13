package com.mydojo.services;

import com.mydojo.dtos.StudentDto;
import com.mydojo.entites.Student;
import com.mydojo.repositories.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Override
    @Transactional
    public List<String> addStudent(StudentDto studentDto){
        List<String> response = new ArrayList<>();
        Student student = new Student(studentDto);
        studentRepository.saveAndFlush(student);
        response.add("Student Added Successfully");
        return response;
    }

    @Override
    public List<StudentDto> getStudentList(){
        return studentRepository.findAll().stream().map(entity -> {
            return new StudentDto(entity);
        }).toList();
    }

    @Override
    public Optional<StudentDto> getStudentById(Long studentId) {
        Optional<Student> studentOptional = studentRepository.findById(studentId);
        if (studentOptional.isPresent()) {
            return Optional.of(new StudentDto(studentOptional.get()));
        }
        return Optional.empty();
    }
}
