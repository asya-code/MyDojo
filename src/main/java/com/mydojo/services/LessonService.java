package com.mydojo.services;

import com.mydojo.dtos.LessonDto;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

public interface LessonService {
    @Transactional
    void createLesson(LessonDto lessonDto, Long coachId);

    @Transactional
    void deleteLessonByIdCoach(Long lessonId);

    @Transactional
    void updateLessonByCoach(LessonDto lessonDto);

    List<LessonDto> getAllLessonByCoach(Long coachId);

    List<LessonDto> getAllLessonByStudent(Long studentId);

    Optional<LessonDto> getLessonById(Long lessonId);

    List<LessonDto> getLessonList();
}
