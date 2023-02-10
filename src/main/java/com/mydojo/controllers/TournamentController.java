package com.mydojo.controllers;

import com.mydojo.dtos.CoachDto;
import com.mydojo.dtos.StudentDto;
import com.mydojo.dtos.TournamentDto;
import com.mydojo.repositories.TournamentRepository;
import com.mydojo.services.TournamentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
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

    @GetMapping("/coach/{coachId}")
    public List<TournamentDto> getAllTournamentByCoach(@PathVariable Long coachId) {
        return tournamentService.getAllTournamentByCoach(coachId);
    }

    @GetMapping("/student/{studentId}")
    public List<TournamentDto> getAllTournamentByStudent(@PathVariable Long studentId) {
        return tournamentService.getAllTournamentByStudent(studentId);
    }

    @PostMapping("/new-tournament")
    public List<String> createNewTournament(@RequestBody TournamentDto tournamentDto){
        System.out.println(tournamentDto.toString());
        return tournamentService.addNewTournament(tournamentDto);
    }

    @GetMapping("/{tournamentId}")
    public Optional<TournamentDto> getTournamentById(@PathVariable Long tournamentId) {
        return tournamentService.getTournamentById(tournamentId);
    }

    @GetMapping("/{tournamentId}/students")
    public List<StudentDto> getStudentList(@PathVariable Long tournamentId){
        return tournamentService.getStudentListByTournamentId(tournamentId);
    }

    @DeleteMapping("/{tournamentId}/students/{studentId}")
    public void deleteStudentFromTournament(@PathVariable Long tournamentId, @PathVariable Long studentId) {
        tournamentService.deleteStudentFromTournament(tournamentId, studentId);
    }

    @GetMapping("/{lessonId}/coaches")
    public List<CoachDto> getCoachList(@PathVariable Long tournamentId){
        return tournamentService.getCoachListByTournamentId(tournamentId);
    }

    @DeleteMapping("/{lessonId}/coaches/{coachId}")
    public void deleteCoachFromLesson(@PathVariable Long tournamentId, @PathVariable Long coachId) {
        tournamentService.deleteCoachFromTournament(tournamentId, coachId);
    }
    @PutMapping("/{tournamentId}")
    public void updateTournament(@PathVariable Long tournamentId,
                                 @RequestBody TournamentDto tournamentDto){
        tournamentService.updateTournament(tournamentDto);
    }

    @DeleteMapping("/{tournamentId}")
    public void deleteTournamentById(@PathVariable Long tournamentId){
        tournamentService.deleteTournamentByIdCoach(tournamentId);
    }

    @PostMapping("/{tournamentId}/add-coach")
    public void addCoachToTournamentSet(@PathVariable Long tournamentId,
                                        @RequestBody CoachDto coachDto) {
        System.out.println("addCoachToTournamentSet " + tournamentId + " : " + coachDto);
        tournamentService.addCoachToTournamentSet(tournamentId, coachDto.getCoachId());
    }

    @PostMapping("/{tournamentId}/add-student")
    public void addStudentToTournamentSet(@PathVariable Long tournamentId,
                                          @RequestBody StudentDto studentDto) {
        System.out.println("addStudentToTournamentSet " + tournamentId + " : " + studentDto);
        tournamentService.addStudentToTournamentSet(tournamentId, studentDto.getStudentId());
    }
//    @PostMapping("/{studentId}/tournaments")
//    public void addLessonForStudent()
}