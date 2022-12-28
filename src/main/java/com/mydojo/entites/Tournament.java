//package com.mydojo.entites;
//
//import org.w3c.dom.Text;
//
//import jakarta.persistence.*;
//import java.sql.Date;
//import java.sql.Time;
//
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//import com.fasterxml.jackson.annotation.JsonManagedReference;
//
//
//@Entity
//@Table(name="Tournaments")
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//public class Tournament {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @Column
//    private String tournamentsName;
//
//    @Column
//    private Text description;
//
//    @Column
//    private String group;
//
//    @Column
//    private String age;
//
//    @Column
//    private Date date;
//
//    @Column
//    private Time time;
//}
//
