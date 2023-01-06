package com.mydojo.dtos;

import com.mydojo.entites.Coach;
import com.mydojo.entites.Lesson;
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
public class CoachDto implements Serializable {
    private Long coachId;
    private String firstName;
    private String lastName;
    private String middleName;
    private Date dob;
    private String email;
    private String password;
    private String image;
    private Date teachingSince;
    private String rank;

    private Set<LessonDto> lessonDtoSet;
    private Set<TournamentDto> tournamentDtoSet;

    public CoachDto(Coach coach){
        if (coach.getCoachId() != null) {
            this.coachId = coach.getCoachId();
        }

        if (coach.getFirstName() != null) {
            this.firstName = coach.getFirstName();
        }

        if (coach.getLastName() != null) {
            this.lastName = coach.getLastName();
        }

        if (coach.getMiddleName() != null) {
            this.middleName = coach.getMiddleName();
        }

        if (coach.getDob() != null) {
            this.dob = coach.getDob();
        }

        if (coach.getEmail() != null) {
            this.email = coach.getEmail();
        }

        if (coach.getPassword() != null) {
            this.password = coach.getPassword();
        }

        if (coach.getImage() != null) {
            this.image = coach.getImage();
        }

        if (coach.getTeachingSince() != null) {
            this.teachingSince = coach.getTeachingSince();
        }

        if (coach.getRank() != null) {
            this.rank = coach.getRank();
        }
    }
}
