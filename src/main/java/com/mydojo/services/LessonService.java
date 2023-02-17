package com.mydojo.services;

import com.mydojo.dtos.CoachDto;
import com.mydojo.dtos.LessonDto;
import com.mydojo.dtos.StudentDto;
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
    void updateLesson(Long lessonId, LessonDto lessonDto);

    @Transactional
    void addCoachToLessonSet(Long lessonId, Long coachId);

    List<LessonDto> getAllLessonByCoach(Long coachId);

    List<LessonDto> getAllLessonByStudent(Long studentId);

    Optional<LessonDto> getLessonById(Long lessonId);

    void deleteCoachFromLesson(Long lessonId, Long coachId);

    List<LessonDto> getLessonList();

    List<CoachDto> getCoachListByLessonId(Long lessonId);

    void deleteStudentFromLesson(Long lessonId, Long studentId);
    List<StudentDto> getStudentListByLessonId(Long lessonID);

    void addStudentToLessonSet(Long lessonId, Long studentId);
}
