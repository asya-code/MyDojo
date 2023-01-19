package com.mydojo.ui;

import com.mydojo.services.CoachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/coaches")
public class uiCoachesController {
    private CoachService coachService;

    @Autowired
    public uiCoachesController(CoachService coachService){
        this.coachService = coachService;
    }
    @GetMapping
    public String viewCoaches(Model model) {
        var listOfCoaches = coachService.getCoachList();
        model.addAttribute("coaches", listOfCoaches);
        return "coaches";
    }
    @GetMapping("/{id}")
    public String viewCoachDetails(Model model, @PathVariable Long id) {
        var coach = coachService.getCoachById(id);
        if(coach.isPresent()){
            model.addAttribute("coach", coach.get());
        }
        return "coach-details";
    }
}
