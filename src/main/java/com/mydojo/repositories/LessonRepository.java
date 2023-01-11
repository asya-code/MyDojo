package com.mydojo.repositories;

import com.mydojo.entites.Coach;
import com.mydojo.entites.Lesson;
import com.mydojo.entites.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LessonRepository extends JpaRepository<Lesson, Long> {
   List<Lesson> findByCoachSet_CoachId(Long coachId);
   List<Lesson> findByStudentSet_StudentId(Long studentId);
}
