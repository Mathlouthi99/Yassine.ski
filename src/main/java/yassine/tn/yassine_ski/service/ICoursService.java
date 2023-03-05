package yassine.tn.yassine_ski.service;

import yassine.tn.yassine_ski.Entities.Cours;
import yassine.tn.yassine_ski.Entities.Moniteur;
import yassine.tn.yassine_ski.Entities.Skieur;

import java.util.List;

public interface ICoursService {

    Iterable<Cours> retrieveAllCourses();

    Cours addCours(Cours cours);
    Cours updateCours(Cours cours);
    Cours retrieveCours(Long numCours);
    List<Cours> findAvailableCoursForSkieur(Skieur skieur);



}
