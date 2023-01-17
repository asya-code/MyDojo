package com.mydojo.entites;

import com.mydojo.dtos.LessonDto;
import jakarta.persistence.Entity;

import jakarta.persistence.*;
import java.sql.Time;
import java.util.Objects;
import java.util.Set;

import lombok.*;

@Entity
@Table(name="Lessons")
@Data
//@Getter
//@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Lesson {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long lessonId;

    @Column
    private String lessonName;

    @Column
    private String art;

    @Column
    private String day;

    @Column
    private Time time;

    @Column
    private String description;

    @ManyToMany(mappedBy = "lessonSet")
    private Set<Student> studentSet;

    @ManyToMany(mappedBy = "lessonSet")
    private Set<Coach> coachSet;

    public Lesson(LessonDto lessonDto){
        if (lessonDto.getLessonId() != null) {
            this.lessonId = lessonDto.getLessonId();
        }

        if (lessonDto.getLessonName() != null) {
            this.lessonName = lessonDto.getLessonName();
        }

        if (lessonDto.getArt() != null) {
            this.art = lessonDto.getArt();
        }

        if (lessonDto.getDay() != null) {
            this.day = lessonDto.getDay();
        }

        if (lessonDto.getTime() != null) {
            this.time = lessonDto.getTime();
        }

        if (lessonDto.getDescription() != null) {
            this.description = lessonDto.getDescription().toString();
        }
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(lessonId);
    }

    @Override
    public boolean equals(Object obj) {
        return  (obj instanceof Lesson ?
                Objects.equals(((Lesson) obj).lessonId, lessonId) : false);
    }
}
