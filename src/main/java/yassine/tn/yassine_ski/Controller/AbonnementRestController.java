package yassine.tn.yassine_ski.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import yassine.tn.yassine_ski.Entities.Abonnement;
import yassine.tn.yassine_ski.service.AbonnementService;

import java.util.List;

@RestController
@RequestMapping("/abonnements")
public class AbonnementRestController {

    @Autowired
    private AbonnementService abonnementService;

    @GetMapping("/all")
    public List<Abonnement> retrieveAllAbonnements() {
        return abonnementService.getAll();
    }

    @PostMapping("/add")
    public Abonnement addAbonnement(@RequestBody Abonnement abonnement) {
        return abonnementService.add(abonnement);
    }

    @PutMapping("/update")
    public Abonnement updateAbonnement(@RequestBody Abonnement abonnement) {
        return abonnementService.update(abonnement);
    }

    @GetMapping("/{id}")
    public Abonnement retrieveAbonnement(@PathVariable("id") Long id) {
        return abonnementService.getById(id);
    }

    @DeleteMapping("/{id}")
    public boolean deleteAbonnement(@PathVariable("id") Long id) {
        return abonnementService.remove(id);
    }
}
