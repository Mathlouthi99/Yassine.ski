package yassine.tn.yassine_ski.service;

import yassine.tn.yassine_ski.Entities.*;
import yassine.tn.yassine_ski.Repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ISkieurServiceImpl implements ISkieurService {

    @Autowired
    private SkieurRepository skieurRepository;

    @Autowired
    private PisteRepository pisteRepository;

    @Autowired
    private AbonnementService abonnementService;

    @Autowired
    private InscriptionService inscriptionService;

    @Autowired
    private ICoursService coursService;
    @Autowired
    private CoursRepository coursRepository;
    @Autowired
    private InscriptionRepository inscriptionRepository;



    @Autowired
    private AbonnementRepository abonnementRepository;


    @Override
    public void add(Skieur s) {
        skieurRepository.save(s);
    }

    @Override
    public Skieur update(Skieur s) {
        return skieurRepository.save(s);
    }

    @Override
    public List<Skieur> getAll() {
        return (List<Skieur>) skieurRepository.findAll();
    }

    @Override
    public Skieur getById(long id) {
        return skieurRepository.findById(id).orElse(null);
    }

    @Override
    public void remove(long id) {
        skieurRepository.deleteById(id);
    }

    public Skieur assignSkieurToPiste(Long numSkieur, Long numPiste) {
        Skieur skieur = skieurRepository.findById(numSkieur)
                .orElseThrow(() -> new IllegalArgumentException("Invalid skieur id: " + numSkieur));
        Piste piste = pisteRepository.findById(numPiste)
                .orElseThrow(() -> new IllegalArgumentException("Invalid piste id: " + numPiste));

        List<Skieur> skieurs = piste.getSkieurs();
        skieurs.add(skieur);
        piste.setSkieurs(skieurs);
        skieurRepository.save(skieur);
        pisteRepository.save(piste);
        return skieurRepository.findById(numSkieur)
                .orElseThrow(() -> new IllegalArgumentException("Invalid skieur id: " + numSkieur));
    }




    public Skieur addSkiuerAndAssignToCourse(Long coursId, Skieur skieur, Abonnement abonnement, Inscription inscription) {
        if (coursId == null) {
            throw new IllegalArgumentException("Cours ID cannot be null");
        }
        Optional<Cours> coursOptional = coursRepository.findById(coursId);

        if (coursOptional.isPresent()) {
            Cours cours = coursOptional.get();
            skieur.setCours(cours);
            skieur.setAbonnement(abonnement);
            List<Inscription> inscriptions = new ArrayList<>();
            inscriptions.add(inscription);
            skieur.setInscriptions(inscriptions);
            skieurRepository.save(skieur);
        } else {
            // handle the case where the Cours object doesn't exist
            throw new IllegalArgumentException("Invalid Cours ID: " + coursId);
        }

        return skieur;
    }




}
