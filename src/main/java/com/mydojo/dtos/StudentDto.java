package com.mydojo.dtos;

import com.mydojo.entites.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import java.io.Serializable;
import java.sql.Time;
import java.util.Date;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDto implements Serializable {
    private Long id;
    private String firstName;
    private String lastName;
    private String middleName;
    private Date dob;
    private String email;
    private String password;
    private String image;
    private Date started;
    private String rank;

//    private Set<LessonDto> lessonDtoSet;

    public StudentDto(Student student){
        if (student.getId() != null) {
            this.id = student.getId();
        }

        if (student.getFirstName() != null) {
            this.firstName = student.getFirstName();
        }

        if (student.getLastName() != null) {
            this.lastName = student.getLastName();
        }

        if (student.getMiddleName() != null) {
            this.middleName = student.getMiddleName();
        }

        if (student.getDob() != null) {
            this.dob = student.getDob();
        }

        if (student.getEmail() != null) {
            this.email = student.getEmail();
        }

        if (student.getPassword() != null) {
            this.password = student.getPassword();
        }

        if (student.getImage() != null) {
            this.image = student.getImage();
        }

        if (student.getStarted() != null) {
            this.started = student.getStarted();
        }

        if (student.getRank() != null) {
            this.rank = student.getRank();
        }
    }
}
