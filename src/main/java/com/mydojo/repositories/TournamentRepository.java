package com.mydojo.repositories;

import com.mydojo.entites.Coach;
import com.mydojo.entites.Lesson;
import com.mydojo.entites.Student;
import com.mydojo.entites.Tournament;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TournamentRepository extends JpaRepository<Tournament, Long> {
    List<Tournament> findByCoachSet_CoachId(Long coachId);
    List<Tournament> findByStudentSet_StudentId(Long studentId);
}
