package com.mydojo.entites;

import com.mydojo.dtos.TournamentDto;
import jakarta.persistence.*;
import java.sql.Date;
import java.sql.Time;

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
    private Long id;

    @Column
    private String tournamentName;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column
    private String group;

    @Column
    private String age;

    @Column
    private Date date;

    @Column
    private Time time;


    public Tournament(TournamentDto tournamentDto) {
        if (tournamentDto.getId() != null) {
            this.id = tournamentDto.getId();
        }

        if (tournamentDto.getTournamentName() != null) {
            this.tournamentName = tournamentDto.getTournamentName();
        }

        if (tournamentDto.getDescription() != null) {
            this.description = tournamentDto.getDescription();
        }

        if (tournamentDto.getGroup() != null) {
            this.group = tournamentDto.getGroup();
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

