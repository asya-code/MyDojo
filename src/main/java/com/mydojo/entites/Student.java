package com.mydojo.entites;

import com.mydojo.dtos.StudentDto;
import jakarta.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="Students")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studentId;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private String middleName;

//    @Column
//    private Date dob;
    @Column
    private String dob;

    @Column(unique = true)
    private String email;

    @Column
    private String image;

//    @Column
//    private Date started;
    @Column
    private String started;

    @Column
    private String rank;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    @JoinTable(name = "students_lessons", joinColumns = {@JoinColumn(name = "student_id")}, inverseJoinColumns = {@JoinColumn(name = "lesson_id")})
    private Set<Lesson> lessonSet = new HashSet<>();

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    @JoinTable(name = "students_tournaments", joinColumns = {@JoinColumn(name = "student_id")}, inverseJoinColumns = {@JoinColumn(name = "tournament_id")})

    private Set<Tournament> tournamentSet = new HashSet<>();

    public Student(String firstName, String lastName, String middleName, String dob,
                 String email, String image, String started, String rank){
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.dob = dob;
        this.email = email;
        this.image = image;
        this.started = started;
        this.rank = rank;
    }

    public Student(StudentDto studentDto) {
        if (studentDto.getStudentId() != null) {
            this.studentId = studentDto.getStudentId();
        }

        if (studentDto.getFirstName() != null) {
            this.firstName = studentDto.getFirstName();
        }

        if (studentDto.getLastName() != null) {
            this.lastName = studentDto.getLastName();
        }

        if (studentDto.getMiddleName() != null) {
            this.middleName = studentDto.getMiddleName();
        }

        if (studentDto.getDob() != null) {
            this.dob = studentDto.getDob();
        }

        if (studentDto.getEmail() != null) {
            this.email = studentDto.getEmail();
        }

        if (studentDto.getImage() != null) {
            this.image = studentDto.getImage();
        }

        if (studentDto.getStarted() != null) {
            this.started = studentDto.getStarted();
        }

        if (studentDto.getRank() != null) {
            this.rank = studentDto.getRank();
        }
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(studentId);
    }

    @Override
    public boolean equals(Object obj) {
        return (obj instanceof Student ?
                Objects.equals(((Student) obj).studentId, studentId) : false);
    }
}