package com.mydojo.dtos;

import com.mydojo.entites.Lesson;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Time;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LessonDto implements Serializable {
    private Long id;
    private String className;
    private String art;
    private String day;
    private Time time;
    private String description;

//    private Set<StudentDto> studentDtoSet;

    public LessonDto(Lesson lesson){
        if (lesson.getId() != null) {
            this.id = lesson.getId();
        }

        if (lesson.getClassName() != null) {
            this.className = lesson.getClassName();
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
}
