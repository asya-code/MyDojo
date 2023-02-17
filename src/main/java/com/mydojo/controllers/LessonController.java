package com.mydojo.controllers;

import com.mydojo.dtos.CoachDto;
import com.mydojo.dtos.LessonDto;
import com.mydojo.dtos.StudentDto;
import com.mydojo.repositories.LessonRepository;
import com.mydojo.services.LessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/api/classes")
public class LessonController {
    @Autowired
    private LessonService lessonService;
    @Autowired
    private LessonRepository lessonRepository;

    @GetMapping("")
    public List<LessonDto> getLessonsList(){
        return lessonService.getLessonList();
    }

    @GetMapping("/coach/{coachId}")
    public List<LessonDto> getAllLessonByCoach(@PathVariable Long coachId) {
        return lessonService.getAllLessonByCoach(coachId);
    }

    @GetMapping("/student/{studentId}")
    public List<LessonDto> getAllLessonByStudent(@PathVariable Long studentId) {
        return lessonService.getAllLessonByStudent(studentId);
    }

    @PostMapping("/new-class")
    public List<String> addNewLesson(@RequestBody LessonDto lessonDto) {
        System.out.println(lessonDto.toString());
        return lessonService.addNewLesson(lessonDto);
    }

    @GetMapping("/{lessonId}")
    public Optional<LessonDto> getLessonById(@PathVariable Long lessonId) {
        return lessonService.getLessonById(lessonId);
    }

    @GetMapping("/{lessonId}/students")
    public List<StudentDto> getStudentList(@PathVariable Long lessonId){
        return lessonService.getStudentListByLessonId(lessonId);
    }

    @DeleteMapping("/{lessonId}/students/{studentId}")
    public void deleteStudentFromLesson(@PathVariable Long lessonId, @PathVariable Long studentId) {
        lessonService.deleteStudentFromLesson(lessonId, studentId);
    }

    @GetMapping("/{lessonId}/coaches")
    public List<CoachDto> getCoachList(@PathVariable Long lessonId){
        return lessonService.getCoachListByLessonId(lessonId);
    }

    @DeleteMapping("/{lessonId}/coaches/{coachId}")
    public void deleteCoachFromLesson(@PathVariable Long lessonId, @PathVariable Long coachId) {
        lessonService.deleteCoachFromLesson(lessonId, coachId);
    }

    @PutMapping("/{lessonId}")
    public void updateLesson(@PathVariable Long lessonId,
                             @RequestBody LessonDto lessonDto){
        lessonService.updateLesson(lessonId, lessonDto);
    }

    @DeleteMapping("/{lessonId}")
    public void deleteLessonById(@PathVariable Long lessonId){
        lessonService.deleteLessonByIdCoach(lessonId);
    }

    @PostMapping("/{lessonId}/add-coach")
    public void addCoachToLessonSet(@PathVariable Long lessonId,
                              @RequestBody CoachDto coachDto){
        System.out.println("addCoachToLessonSet " + lessonId + " : " + coachDto);
        lessonService.addCoachToLessonSet(lessonId, coachDto.getCoachId());
    }

    @PostMapping("/{lessonId}/add-student")
    public void addStudentToLessonSet(@PathVariable Long lessonId,
                              @RequestBody StudentDto studentDto){
        System.out.println("/n" + " addStudentToLessonSet " + lessonId + " : " + studentDto);
        lessonService.addStudentToLessonSet(lessonId, studentDto.getStudentId());
    }
//    @PostMapping("/{studentId}/classes")
//    public void addLessonForStudent()
}