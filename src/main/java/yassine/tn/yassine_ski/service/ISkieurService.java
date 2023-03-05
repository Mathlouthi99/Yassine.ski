package yassine.tn.yassine_ski.service;

import yassine.tn.yassine_ski.Entities.Abonnement;
import yassine.tn.yassine_ski.Entities.Inscription;
import yassine.tn.yassine_ski.Entities.Skieur;

import java.util.List;

public interface ISkieurService {

    void add(Skieur s);

    Skieur update(Skieur s);

    List<Skieur> getAll();

    Skieur getById(long id);

    void remove(long id);

    Skieur assignSkieurToPiste(Long numSkieur, Long numPiste);
    Skieur addSkiuerAndAssignToCourse(Long coursId, Skieur skieur, Abonnement abonnement, Inscription inscription);
}
