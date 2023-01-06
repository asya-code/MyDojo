package com.mydojo.services;

import com.mydojo.dtos.LessonDto;
import com.mydojo.entites.Coach;
import com.mydojo.entites.Lesson;
import com.mydojo.entites.Student;
import com.mydojo.repositories.CoachRepository;
import com.mydojo.repositories.LessonRepository;
import com.mydojo.repositories.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LessonServiceImpl implements LessonService {
    @Autowired
    private LessonRepository lessonRepository;

    @Autowired
    private CoachRepository coachRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Override
    @Transactional
    public void createLesson(LessonDto lessonDto, Long coachId) {
        Optional<Coach> coachOptional = coachRepository.findById(coachId);
        Lesson lesson = new Lesson(lessonDto);
        if (coachOptional.isPresent()){
            lesson.getCoachSet().add(coachOptional.get());
        }
        lessonRepository.saveAndFlush(lesson);
    }

    @Override
    @Transactional
    public void deleteLessonByIdCoach(Long lessonId){
        Optional<Lesson> lessonOptional = lessonRepository.findById(lessonId);
        lessonOptional.ifPresent(lesson -> lessonRepository.delete(lesson));
    }

    @Override
    @Transactional
    public void updateLessonByCoach(LessonDto lessonDto){
        Optional<Lesson> lessonOptional = lessonRepository.findById(lessonDto.getLessonId());
        lessonOptional.ifPresent(lesson -> {
            lesson.setLessonName(lessonDto.getLessonName());
            lesson.setArt(lessonDto.getArt());
            lesson.setDay(lessonDto.getDay());
            lesson.setTime(lessonDto.getTime());
            lesson.setDescription(lessonDto.getDescription());
            lesson.setCoachSet(lessonDto.getCoachSet());
            lesson.setStudentSet(lessonDto.getStudentSet());
            lessonRepository.saveAndFlush(lesson);
        });
    }

    @Override
    public List<LessonDto> getAllLessonByCoach(Long coachId) {
        Optional<Coach> coachOptional = coachRepository.findById(coachId);
        if (coachOptional.isPresent()) {
            List<Lesson> lessonList = lessonRepository.findAllByCoachEquals(coachOptional.get());
            return lessonList.stream().map(lesson -> new LessonDto(lesson)).collect(Collectors.toList());
        }
        return Collections.emptyList();
    }

    @Override
    public List<LessonDto> getAllLessonByStudent(Long studentId) {
        Optional<Student> studentOptional = studentRepository.findById(studentId);
        if (studentOptional.isPresent()) {
            List<Lesson> lessonList = lessonRepository.findAllByStudentEquals(studentOptional.get());
            return lessonList.stream().map(lesson -> new LessonDto(lesson)).collect(Collectors.toList());
        }
        return Collections.emptyList();
    }
}
