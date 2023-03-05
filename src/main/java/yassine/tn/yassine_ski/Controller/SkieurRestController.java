package yassine.tn.yassine_ski.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import yassine.tn.yassine_ski.Entities.Abonnement;
import yassine.tn.yassine_ski.Entities.Inscription;
import yassine.tn.yassine_ski.Entities.Piste;
import yassine.tn.yassine_ski.Entities.Skieur;
import yassine.tn.yassine_ski.Repositories.AbonnementRepository;
import yassine.tn.yassine_ski.Repositories.InscriptionRepository;
import yassine.tn.yassine_ski.service.IPisteService;
import yassine.tn.yassine_ski.service.ISkieurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/skieurs")
public class SkieurRestController {

    @Autowired
    private ISkieurService skieurService;

    @Autowired
    private IPisteService pisteService;
    @Autowired
    private AbonnementRepository abonnementRepository;

    @Autowired
    private InscriptionRepository inscriptionRepository;

    @PostMapping("/add")
    public void add(@RequestBody Skieur skieur) {
        skieurService.add(skieur);
    }

    @PutMapping("/update")
    public Skieur update(@RequestBody Skieur skieur) {
        return skieurService.update(skieur);
    }

    @GetMapping("/all")
    public List<Skieur> getAll() {
        return skieurService.getAll();
    }

    @GetMapping("/{id}")
    public Skieur getById(@PathVariable long id) {
        return skieurService.getById(id);
    }

    @DeleteMapping("/remove/{id}")
    public void remove(@PathVariable long id) {
        skieurService.remove(id);
    }

    @PostMapping("/skieurs/{numSkieur}/pistes/{numPiste}")
    public Skieur assignSkieurToPiste(@PathVariable Long numSkieur, @PathVariable Long numPiste) {
        return skieurService.assignSkieurToPiste(numSkieur, numPiste);
    }

    @PostMapping("/addAndAssignToCourse")
    public Skieur addSkiuerAndAssignToCourse(@RequestParam Long coursId,
                                             @RequestBody Skieur skieur,
                                             @RequestParam Long abonnementId,
                                             @RequestParam Long inscriptionId) {
        Abonnement abonnement = abonnementRepository.findById(abonnementId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid Abonnement ID: " + abonnementId));
        Inscription inscription = inscriptionRepository.findById(inscriptionId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid Inscription ID: " + inscriptionId));

        return skieurService.addSkiuerAndAssignToCourse(coursId, skieur, abonnement, inscription);
    }



}
