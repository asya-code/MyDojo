package com.mydojo.dtos;

import com.mydojo.entites.Coach;
import com.mydojo.entites.Lesson;
import com.mydojo.entites.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Time;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LessonDto implements Serializable {
    private Long lessonId;
    private String lessonName;
    private String art;
    private String day;
    private Time time;
    private String description;

    private Set<StudentDto> studentDtoSet;
    private Set<CoachDto> coachDtoSet;

    public LessonDto(Lesson lesson){
        if (lesson.getLessonId() != null) {
            this.lessonId = lesson.getLessonId();
        }

        if (lesson.getLessonName() != null) {
            this.lessonName = lesson.getLessonName();
        }

        if (lesson.getArt() != null) {
            this.art = lesson.getArt();
        }

        if (lesson.getDay() != null) {
            this.day = lesson.getDay();
        }

        if (lesson.getTime() != null) {
            this.time = lesson.getTime();
        }

        if (lesson.getDescription() != null) {
            this.description = lesson.getDescription();
        }
    }

    public Set<Coach> getCoachSet(){
        Set <Coach> coachSet = new HashSet<>();
        for (CoachDto each : coachDtoSet){
            Coach temporaryCoach = new Coach(each);
            coachSet.add(temporaryCoach);
        }
        return coachSet;
    }

    public Set<Student> getStudentSet() {
        Set <Student> studentSet = new HashSet<>();
        for (StudentDto each : studentDtoSet) {
            Student temporaryStudent = new Student(each);
            studentSet.add(temporaryStudent);
        }
        return studentSet;
    }
}
