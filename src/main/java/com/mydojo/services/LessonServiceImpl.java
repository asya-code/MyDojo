package com.mydojo.services;

import com.mydojo.dtos.CoachDto;
import com.mydojo.dtos.LessonDto;
import com.mydojo.dtos.StudentDto;
import com.mydojo.entites.Coach;
import com.mydojo.entites.Lesson;
import com.mydojo.entites.Student;
import com.mydojo.repositories.CoachRepository;
import com.mydojo.repositories.LessonRepository;
import com.mydojo.repositories.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
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
    public List<String> addNewLesson(LessonDto lessonDto) {
        List<String> response = new ArrayList<>();
        Lesson lesson = new Lesson(lessonDto);
        lessonRepository.saveAndFlush(lesson);
        System.out.println(lesson);
        response.add("Class Added Successfully");
        return response;
    }

    @Override
    @Transactional
    public void deleteLessonByIdCoach(Long lessonId){
        Optional<Lesson> lessonOptional = lessonRepository.findById(lessonId);
        lessonOptional.ifPresent(lesson -> lessonRepository.delete(lesson));
    }

    @Override
    @Transactional
    public void updateLesson(LessonDto lessonDto){
        Optional<Lesson> lessonOptional = lessonRepository.findById(lessonDto.getLessonId());
        lessonOptional.ifPresent(lesson -> {
            lesson.setLessonName(lessonDto.getLessonName());
            lesson.setArt(lessonDto.getArt());
            lesson.setDay(lessonDto.getDay());
            lesson.setTime(lessonDto.getTime());
            lesson.setDescription(lessonDto.getDescription());
//            lesson.setCoachSet(lessonDto.getCoachSet());
//            lesson.setStudentSet(lessonDto.getStudentSet());
            lessonRepository.saveAndFlush(lesson);
        });
    }

    @Transactional
    @Override
    public void addCoachToLessonSet(Long lessonId, Long coachId) {
        Optional<Lesson> lessonOptional = lessonRepository.findById(lessonId);
        if (!lessonOptional.isPresent()) {
            System.out.println("addCoachToSet lesson not found: " + lessonId);
            return;
        }

        Optional<Coach> coachOptional = coachRepository.findById(coachId);
        if (!coachOptional.isPresent()) {
            System.out.println("addCoachToSet coach not found: " + coachId);
            return;
        }

        Lesson lesson = lessonOptional.get();
        lesson.getCoachSet().add(coachOptional.get());
        coachOptional.get().getLessonSet().add(lesson);
        lessonRepository.saveAndFlush(lesson);
    }

    @Override
    public List<LessonDto> getAllLessonByCoach(Long coachId) {
        Optional<Coach> coachOptional = coachRepository.findById(coachId);
        if (coachOptional.isPresent()) {
            List<Lesson> lessonList = lessonRepository.findByCoachSet_CoachId(coachOptional.get().getCoachId());
            return lessonList.stream().map(lesson -> new LessonDto(lesson)).collect(Collectors.toList());
        }
        return Collections.emptyList();
    }

    @Override
    public List<LessonDto> getAllLessonByStudent(Long studentId) {
        Optional<Student> studentOptional = studentRepository.findById(studentId);
        if (studentOptional.isPresent()) {
            List<Lesson> lessonList = lessonRepository.findByStudentSet_StudentId(studentOptional.get().getStudentId());
            return lessonList.stream().map(lesson -> new LessonDto(lesson)).collect(Collectors.toList());
        }
        return Collections.emptyList();
    }

    @Override
    public Optional<LessonDto> getLessonById(Long lessonId) {
        Optional<Lesson> lessonOptional = lessonRepository.findById(lessonId);
        if (lessonOptional.isPresent()) {
            return Optional.of(new LessonDto((lessonOptional.get())));
        }
        return Optional.empty();
    }
    @Override
    public List<StudentDto> getStudentListByLessonId(Long lessonId){
        Optional<Lesson> lessonOptional = lessonRepository.findById(lessonId);
        if (lessonOptional.isPresent()) {
            return lessonOptional.get().getStudentSet().stream().map(entity -> {
                return new StudentDto(entity);
            }).toList();
        } else {
            return List.of();
        }
    }

    @Override
    public void deleteStudentFromLesson(Long lessonId, Long studentId) {
        Optional<Lesson> lessonOptional = lessonRepository.findById(lessonId);
        Optional<Student> studentOptional = studentRepository.findById(studentId);
        if (lessonOptional.isPresent() && studentOptional.isPresent()) {
            lessonOptional.get().getStudentSet().remove(studentOptional.get());
            studentOptional.get().getLessonSet().remove(lessonOptional.get());
            lessonRepository.saveAndFlush(lessonOptional.get());
            studentRepository.saveAndFlush(studentOptional.get());
        }
    }

    @Override
    public List<CoachDto> getCoachListByLessonId(Long lessonId){
        Optional<Lesson> lessonOptional = lessonRepository.findById(lessonId);
        if (lessonOptional.isPresent()) {
            return lessonOptional.get().getCoachSet().stream().map(entity -> {
                return new CoachDto(entity);
            }).toList();
        } else {
            return List.of();
        }
    }

    @Override
    public void deleteCoachFromLesson(Long lessonId, Long coachId) {
        Optional<Lesson> lessonOptional = lessonRepository.findById(lessonId);
        Optional<Coach> coachOptional = coachRepository.findById(coachId);
        if (lessonOptional.isPresent() && coachOptional.isPresent()) {
            lessonOptional.get().getCoachSet().remove(coachOptional.get());
            coachOptional.get().getLessonSet().remove(lessonOptional.get());
            lessonRepository.saveAndFlush(lessonOptional.get());
            coachRepository.saveAndFlush(coachOptional.get());
        }
    }
    @Override
    public List<LessonDto> getLessonList() {
        return lessonRepository.findAll().stream().map(entity -> {
            for (Coach coach : entity.getCoachSet()) {
                // ignore
                System.out.println("!!!!!  Found coach " + coach.getCoachId()
                        + " for lesson " + entity.getLessonId());
            }
            return new LessonDto(entity);
        }).toList();
    }

    @Override
    public void addStudentToLessonSet(Long lessonId, Long studentId) {
        Optional<Lesson> lessonOptional = lessonRepository.findById(lessonId);
        if (!lessonOptional.isPresent()) {
            System.out.println("addStudentToLessonSet lesson not found: " + lessonId);
            return;
        }

        Optional<Student> studentOptional = studentRepository.findById(studentId);
        if (!studentOptional.isPresent()) {
            System.out.println("addStudentToLessonSet student not found: " + studentId);
            return;
        }

        Lesson lesson = lessonOptional.get();
        lesson.getStudentSet().add(studentOptional.get());
        studentOptional.get().getLessonSet().add(lesson);
        lessonRepository.saveAndFlush(lesson);
    }
}
