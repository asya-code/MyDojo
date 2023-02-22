package com.mydojo.dtos;

import com.mydojo.entites.Coach;
import com.mydojo.entites.Tournament;
import com.mydojo.entites.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TournamentDto implements Serializable {
    private Long tournamentId;
    private String tournamentName;
    private String description;
    private String art;
    private String age;
//    private Date date;
    private String date;
//    private Time time;
    private String time;

    private Set<StudentDto> studentDtoSet;
    private Set<CoachDto> coachDtoSet;

    public TournamentDto(Tournament tournament) {
        if (tournament.getTournamentId() != null) {
            this.tournamentId = tournament.getTournamentId();
        }

        if (tournament.getTournamentName() != null) {
            this.tournamentName = tournament.getTournamentName();
        }

        if (tournament.getDescription() != null) {
            this.description = tournament.getDescription();
        }

        if (tournament.getArt() != null) {
            this.art = tournament.getArt();
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

//    public Set<Coach> getCoachSet(){
//        Set <Coach> coachSet = new HashSet<>();
//        for (CoachDto each : coachDtoSet){
//            Coach temporaryCoach = new Coach(each);
//            coachSet.add(temporaryCoach);
//        }
//        return coachSet;
//    }
//
//    public Set<Student> getStudentSet() {
//        Set <Student> studentSet = new HashSet<>();
//        for (StudentDto each : studentDtoSet) {
//            Student temporaryStudent = new Student(each);
//            studentSet.add(temporaryStudent);
//        }
//        return studentSet;
//    }
}

