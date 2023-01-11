package com.mydojo.controllers;

import com.mydojo.dtos.CoachDto;
import com.mydojo.dtos.LessonDto;
import com.mydojo.repositories.LessonRepository;
import com.mydojo.services.LessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/classes")
public class LessonController {
    @Autowired
    private LessonService lessonService;
    @Autowired
    private LessonRepository lessonRepository;

    @GetMapping("/{coachId}/classes")
    public List<LessonDto> getAllLessonsByCoach(@PathVariable Long coachId) {
        return lessonService.getAllLessonByCoach(coachId);
    }

    @GetMapping("/{studentId}/classes")
    public List<LessonDto> getAllLessonsByStudent(@PathVariable Long studentId) {
        return lessonService.getAllLessonByStudent(studentId);
    }

    @GetMapping("/{lessonId}")
    public Optional<LessonDto> getLessonById(@PathVariable Long lessonId) {
        return lessonService.getLessonById(lessonId);
    }

    // this should be available only for logged in coaches
    @PostMapping("/{coachId}/new-class")
    public void createNewClass(@RequestBody LessonDto lessonDto, @PathVariable Long coachId){
        lessonService.createLesson(lessonDto, coachId);
        System.out.println("Class added successfully");
    }

    @GetMapping("")
    public List<LessonDto> getAllLessons(){

        return lessonService.getLessonList();
    }

    @PutMapping
    // this should be available only for logged in coaches
    public void updateLesson(@RequestBody LessonDto lessonDto){
        lessonService.updateLessonByCoach(lessonDto);
    }

    // this should be available only for logged in coaches
    @DeleteMapping("/{lessonId}")
    public void deleteLessonById(@PathVariable Long lessonId){
        lessonService.deleteLessonByIdCoach(lessonId);
    }

//    @PostMapping("/{studentId}/classes")
//    public void addLessonForStudent()

}
