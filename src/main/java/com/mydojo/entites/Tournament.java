package com.mydojo.entites;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.mydojo.dtos.TournamentDto;
import jakarta.persistence.*;

import java.sql.Time;
import java.util.Date;
import java.util.Objects;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name="Tournaments")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Tournament {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tournamentId;

    @Column
    private String tournamentName;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column
    private String art;

    @Column
    private String age;

//    @Column(name = "\"date\"")
//    @JsonFormat(pattern="yyyy-MM-dd")
//    private Date date;
    @Column
    private String date;

//    @Column
//    private Time time;
    @Column
    private String time;

    @ManyToMany(mappedBy = "tournamentSet")
    private Set<Coach> coachSet;

    @ManyToMany(mappedBy = "tournamentSet")
    private Set<Student> studentSet;

    public Tournament(String tournamentName, String description, String art, String age, String date, String time){
        this.tournamentName = tournamentName;
        this.description = description;
        this.art = art;
        this.age = age;
        this.date = date;
        this.time = time;
    }

    public Tournament(TournamentDto tournamentDto) {
        if (tournamentDto.getTournamentId() != null) {
            this.tournamentId = tournamentDto.getTournamentId();
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
            this.date = tournamentDto.getDate();
        }

        if (tournamentDto.getTime() != null) {
            this.time = tournamentDto.getTime();
        }

    }
    @Override
    public int hashCode() {
        return Objects.hashCode(tournamentId);
    }

    @Override
    public boolean equals(Object obj) {
        return  (obj instanceof Tournament ?
                Objects.equals(((Tournament) obj).tournamentId, tournamentId) : false);
    }

}

