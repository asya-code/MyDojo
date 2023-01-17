package com.mydojo.services;

import com.mydojo.dtos.LessonDto;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

public interface LessonService {
    @Transactional
//    void addNewLesson(LessonDto lessonDto, Long coachId);
    List<String> addNewLesson(LessonDto lessonDto);

    @Transactional
    void deleteLessonByIdCoach(Long lessonId);

    @Transactional
    void updateLesson(LessonDto lessonDto);

    @Transactional
    void addCoachToLessonSet(Long lessonId, Long coachId);

    List<LessonDto> getAllLessonByCoach(Long coachId);

    List<LessonDto> getAllLessonByStudent(Long studentId);

    Optional<LessonDto> getLessonById(Long lessonId);

    List<LessonDto> getLessonList();

    void addStudentToLessonSet(Long lessonId, Long studentId);
}
