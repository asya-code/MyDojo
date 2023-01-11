package com.mydojo.controllers;

import com.mydojo.dtos.StudentDto;
import com.mydojo.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/registerStudent")
    public List<String> addStudent(@RequestBody StudentDto studentDto) {
        System.out.println(studentDto.toString());
        String passHash = passwordEncoder.encode((studentDto.getPassword()));
        studentDto.setPassword(passHash);
        return studentService.addStudent(studentDto);
    }

    @PostMapping("/login")
    public List<String> studentLogin(@RequestBody StudentDto studentDto) {
        return studentService.studentLogin(studentDto);
    }

    @GetMapping("")
    public List<StudentDto> getAllStudents(){
        return studentService.getStudentList();
    }

    @GetMapping("/{studentId}")
    public Optional<StudentDto> getStudentById(@PathVariable Long studentId){
        return studentService.getStudentById(studentId);
    }
}












