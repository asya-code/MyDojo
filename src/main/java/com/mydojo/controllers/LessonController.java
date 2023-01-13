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

    @GetMapping("")
    public List<LessonDto> getAllLessons(){

        return lessonService.getLessonList();
    }

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

    @PutMapping("/{lessonId}")
    public void updateLesson(@PathVariable Long lessonId, @RequestBody LessonDto lessonDto){
        lessonService.updateLesson(lessonDto);
    }

    @PostMapping("/{lessonId}/coaches")
    public void addCoachToSet(@PathVariable Long lessonId, @RequestBody CoachDto coachDto){
        lessonService.addCoachToSet(lessonId, coachDto.getCoachId());
    }



    // this should be available only for logged in coaches
    @PostMapping("/new-class")
    public List<String> addNewLesson(@RequestBody LessonDto lessonDto) {
        System.out.println(lessonDto.toString());
        return lessonService.addNewLesson(lessonDto);
    }

    // this should be available only for logged in coaches
    @DeleteMapping("/{lessonId}")
    public void deleteLessonById(@PathVariable Long lessonId){
        lessonService.deleteLessonByIdCoach(lessonId);
    }

//    @PostMapping("/{studentId}/classes")
//    public void addLessonForStudent()

}
