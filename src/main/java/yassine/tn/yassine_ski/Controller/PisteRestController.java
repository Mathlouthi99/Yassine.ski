package yassine.tn.yassine_ski.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import yassine.tn.yassine_ski.Entities.Piste;
import yassine.tn.yassine_ski.service.IPisteService;

import java.util.List;

@RestController
@RequestMapping("/piste")
public class PisteRestController {

    @Autowired
    private IPisteService pisteService;

    @GetMapping
    public List<Piste> retrieveAllPistes() {
        return pisteService.retrieveAllPistes();
    }

    @PostMapping("/add")
    public Piste addPiste(@RequestBody Piste piste) {
        return pisteService.addPiste(piste);
    }

    @PutMapping
    public Piste updatePiste(@RequestBody Piste piste) {
        return pisteService.updatePiste(piste);
    }

    @GetMapping("/{numPiste}")
    public Piste retrievePiste(@PathVariable Long numPiste) {
        return pisteService.retrievePiste(numPiste);
    }

    @DeleteMapping("/{numPiste}")
    public void deletePiste(@PathVariable Long numPiste) {
        pisteService.deletePiste(numPiste);
    }
}
