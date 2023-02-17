package com.mydojo.controllers;

import com.mydojo.dtos.CoachDto;
import com.mydojo.dtos.LessonDto;
import com.mydojo.dtos.StudentDto;
import com.mydojo.dtos.UserDto;
import com.mydojo.services.StudentService;
import com.mydojo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/api/students")
public class StudentController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private UserService userService;

    @PostMapping("/registerStudent")
    public List<String> registerStudent(@RequestBody StudentDto studentDto) {
        System.out.println(studentDto.toString());

        Optional<UserDto> user = userService.findByEmail(studentDto.getEmail());

        if (!user.isPresent()) {
            userService.addByEmail(studentDto.getEmail(), studentDto.getPassword());
            user = userService.findByEmail(studentDto.getEmail());
            if (!user.isPresent()) {
                throw new RuntimeException("New user not found");
            }
        }

        return studentService.addStudent(studentDto);
    }

    @GetMapping("/all")
    public List<StudentDto> getAllStudents(){
        return studentService.getStudentList();
    }

    @GetMapping("/id/{studentId}")
    public Optional<StudentDto> getStudentById(@PathVariable Long studentId){
        return studentService.getStudentById(studentId);
    }

    @PutMapping("/id/{studentId}")
    public void updateStudent(@PathVariable Long studentId,
                             @RequestBody StudentDto studentDto){
        studentService.updateStudent(studentId, studentDto);
    }
}
