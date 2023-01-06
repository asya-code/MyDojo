package com.mydojo.entites;

import com.mydojo.dtos.TournamentDto;
import jakarta.persistence.*;
import java.sql.Date;
import java.sql.Time;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
@Table(name="Tournaments")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Tournament {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tournametId;

    @Column
    private String tournamentName;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column
    private String art;

    @Column
    private String age;

    @Column(name = "\"date\"")
    private Date date;

    @Column
    private Time time;

    @ManyToMany(mappedBy = "tournamentSet")
    private Set<Coach> coachSet;

    @ManyToMany(mappedBy = "tournamentSet")
    private Set<Student> studentSet;

    public Tournament(TournamentDto tournamentDto) {
        if (tournamentDto.getTournamentId() != null) {
            this.tournametId = tournamentDto.getTournamentId();
        }

        if (tournamentDto.getTournamentName() != null) {
            this.tournamentName = tournamentDto.getTournamentName();
        }

        if (tournamentDto.getDescription() != null) {
            this.description = tournamentDto.getDescription();
        }

        if (tournamentDto.getArt() != null) {
            this.art = tournamentDto.getArt();
        }

        if (tournamentDto.getAge() != null) {
            this.age = tournamentDto.getAge();
        }

        if (tournamentDto.getDate() != null) {
            this.date = (Date) tournamentDto.getDate();
        }

        if (tournamentDto.getTime() != null) {
            this.time = tournamentDto.getTime();
        }

    }

}

