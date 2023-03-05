package yassine.tn.yassine_ski.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import yassine.tn.yassine_ski.Entities.Moniteur;
import yassine.tn.yassine_ski.service.IMoniteurService;

import java.util.List;

@RestController
@RequestMapping("/moniteurs")
public class MoniteurRestController {

    @Autowired
    private IMoniteurService moniteurService;

    @GetMapping("/all")
    public List<Moniteur> retrieveAllMoniteurs() {
        return moniteurService.retrieveAllMoniteurs();
    }

    @PostMapping("/add")
    public Moniteur addMoniteur(@RequestBody Moniteur moniteur) {
        return moniteurService.addMoniteur(moniteur);
    }

    @PutMapping("/update")
    public Moniteur updateMoniteur(@RequestBody Moniteur moniteur) {
        return moniteurService.updateMoniteur(moniteur);
    }

    @GetMapping("/{numMoniteur}")
    public Moniteur retrieveMoniteur(@PathVariable("numMoniteur") Long numMoniteur) {
        return moniteurService.retrieveMoniteur(numMoniteur);
    }

    @DeleteMapping("/{numMoniteur}")
    public void deleteMoniteur(@PathVariable("numMoniteur") Long numMoniteur) {
        moniteurService.delete(numMoniteur);
    }

    @PostMapping("/{numMoniteur}/assign/{numCourse}")
    public Moniteur addInstructorAndAssignToCourse(@PathVariable("numMoniteur") Long numMoniteur,
                                                   @PathVariable("numCourse") Long numCourse) {
        Moniteur moniteur = moniteurService.retrieveMoniteur(numMoniteur);
        return moniteurService.addInstructorAndAssignToCourse(moniteur, numCourse);
    }

}
