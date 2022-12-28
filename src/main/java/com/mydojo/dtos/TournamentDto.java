package com.mydojo.dtos;

import com.mydojo.entites.Coach;
import com.mydojo.entites.Tournament;
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
public class TournamentDto implements Serializable {
    private Long id;
    private String tournamentName;
    private String description;
    private String group;
    private String age;
    private Date date;
    private Time time;


    public TournamentDto(Tournament tournament) {
        if (tournament.getId() != null) {
            this.id = tournament.getId();
        }

        if (tournament.getTournamentName() != null) {
            this.tournamentName = tournament.getTournamentName();
        }

        if (tournament.getDescription() != null) {
            this.description = tournament.getDescription();
        }

        if (tournament.getGroup() != null) {
            this.group = tournament.getGroup();
        }

        if (tournament.getAge() != null) {
            this.age = tournament.getAge();
        }

        if (tournament.getDate() != null) {
            this.date = tournament.getDate();
        }

        if (tournament.getTime() != null) {
            this.time = tournament.getTime();
        }

    }
}

