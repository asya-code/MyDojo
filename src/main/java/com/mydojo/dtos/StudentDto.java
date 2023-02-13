package com.mydojo.dtos;

import com.mydojo.entites.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDto implements Serializable {
    private Long studentId;
    private String firstName;
    private String lastName;
    private String middleName;
    private String password;
    private Date dob;
    private String email;
    private String image;
    private Date started;
    private String rank;

    private Set<LessonDto> lessonDtoSet;
    private Set<TournamentDto> tournamentDtoSet;

    public StudentDto(Student student){
        if (student.getStudentId() != null) {
            this.studentId = student.getStudentId();
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
