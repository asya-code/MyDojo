package com.mydojo.entites;

import com.mydojo.dtos.LessonDto;
import jakarta.persistence.Entity;

import jakarta.persistence.*;
import java.sql.Time;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="Classes")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Lesson {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String className;

    @Column
    private String group;

    @Column
    private String day;

    @Column
    private Time time;

    @Column
    private String description;

//    @ManyToMany(mappedBy = "lessonSet")
//    private Set<Student> studentsSet;

    public Lesson(LessonDto lessonDto){
        if (lessonDto.getId() != null) {
            this.id = lessonDto.getId();
        }

        if (lessonDto.getClassName() != null) {
            this.className = lessonDto.getClassName();
        }

        if (lessonDto.getGroup() != null) {
            this.group = lessonDto.getGroup();
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

}
