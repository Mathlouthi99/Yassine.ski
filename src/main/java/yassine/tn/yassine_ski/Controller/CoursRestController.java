package yassine.tn.yassine_ski.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import yassine.tn.yassine_ski.Entities.Cours;
import yassine.tn.yassine_ski.service.ICoursService;

import java.util.List;

@RestController
@RequestMapping("/cours")
public class CoursRestController {

    @Autowired
    private ICoursService coursService;

 /*   @GetMapping("/all")
    public List<Cours> retrieveAllCourses() {
        return coursService.retrieveAllCourses();
    }*/

    @PostMapping("/add")
    public Cours addCours(@RequestBody Cours cours) {
        return coursService.addCours(cours);
    }

    @PutMapping("/update")
    public Cours updateCours(@RequestBody Cours cours) {
        return coursService.updateCours(cours);
    }

    @GetMapping("/{numCours}")
    public Cours retrieveCours(@PathVariable("numCours") Long numCours) {
        return coursService.retrieveCours(numCours);
    }

}
