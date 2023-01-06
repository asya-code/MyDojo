package com.mydojo.entites;

import com.mydojo.dtos.CoachDto;
import jakarta.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="Coaches")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Coach {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long coachId;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private String middleName;

    @Column
    private Date dob;

    @Column(unique = true)
    private String email;

    @Column
    private String password;

    @Column
    private String image;

    @Column
    private Date teachingSince;

    @Column
    private String rank;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinTable(name = "coaches_lessons", joinColumns = {@JoinColumn(name = "coach_id")}, inverseJoinColumns = {@JoinColumn(name = "lesson_id")})
    private Set<Lesson> lessonSet = new HashSet<>();

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinTable(name = "coaches_tournaments", joinColumns = {@JoinColumn(name = "coach_id")}, inverseJoinColumns = {@JoinColumn(name = "tournament_id")})

    private Set<Tournament> tournamentSet = new HashSet<>();

    public Coach (CoachDto coachDto) {
        if (coachDto.getCoachId() != null) {
                this.coachId = coachDto.getCoachId();
            }
        if (coachDto.getFirstName() != null) {
            this.firstName = coachDto.getFirstName();
        }

        if (coachDto.getLastName() != null) {
            this.lastName = coachDto.getLastName();
        }

        if (coachDto.getMiddleName() != null) {
            this.middleName = coachDto.getMiddleName();
        }

        if (coachDto.getDob() != null) {
            this.dob = coachDto.getDob();
        }

        if (coachDto.getEmail() != null) {
            this.email = coachDto.getEmail();
        }

        if (coachDto.getPassword() != null) {
            this.password = coachDto.getPassword();
        }

        if (coachDto.getImage() != null) {
            this.image = coachDto.getImage();
        }

        if (coachDto.getTeachingSince() != null) {
            this.teachingSince = coachDto.getTeachingSince();
        }

        if (coachDto.getRank() != null) {
            this.rank = coachDto.getRank();
        }

    }
}
