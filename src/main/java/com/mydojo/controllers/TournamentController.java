package com.mydojo.controllers;

import com.mydojo.dtos.CoachDto;
import com.mydojo.dtos.TournamentDto;
import com.mydojo.repositories.LessonRepository;
import com.mydojo.repositories.TournamentRepository;
import com.mydojo.services.TournamentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tournaments")
public class TournamentController {
    @Autowired
    private TournamentService tournamentService;
    @Autowired
    private TournamentRepository tournamentRepository;

    @GetMapping("")
    public List<TournamentDto> getTournamentList(){

        return tournamentService.getTournamentList();
    }

    @GetMapping("/{coachId}/tournaments")
    public List<TournamentDto> getAllTournamentByCoach(@PathVariable Long coachId) {
        return tournamentService.getAllTournamentByCoach(coachId);
    }

    @GetMapping("/{studentId}/tournaments")
    public List<TournamentDto> getAllTournamentByStudent(@PathVariable Long studentId) {
        return tournamentService.getAllTournamentByStudent(studentId);
    }

    @GetMapping("/{tournamentId}")
    public Optional<TournamentDto> getLessonById(@PathVariable Long tournamentId) {
        return tournamentService.getTournamentById(tournamentId);
    }

    // this should be available only for logged in coaches
    @PostMapping("/{coachId}/new-tournament")
    public void createNewTournament(@RequestBody TournamentDto tournamentDto, @PathVariable Long coachId){
        tournamentService.createTournament(tournamentDto, coachId);
        System.out.println("Tournament added successfully");
    }

    @PutMapping()
    // this should be available only for logged in coaches
    public void updateTournament(@RequestBody TournamentDto tournamentDto){
        tournamentService.updateTournamentByCoach(tournamentDto);
    }

    // this should be available only for logged in coaches
    @DeleteMapping("/{tournamentId}")
    public void deleteTournamentById(@PathVariable Long tournamentId){
        tournamentService.deleteTournamentByIdCoach(tournamentId);
    }

//    @PostMapping("/{studentId}/tournaments")
//    public void addLessonForStudent()


}
