package com.mydojo.services;

import com.mydojo.dtos.LessonDto;
import jakarta.transaction.Transactional;

import java.util.List;

public interface LessonService {
    @Transactional
    void createLesson(LessonDto lessonDto, Long coachId);

    @Transactional
    void deleteLessonByIdCoach(Long lessonId);

    @Transactional
    void updateLessonByCoach(LessonDto lessonDto);

    List<LessonDto> getAllLessonByCoach(Long coachId);

    List<LessonDto> getAllLessonByStudent(Long studentId);
}
