package yassine.tn.yassine_ski.service;

import yassine.tn.yassine_ski.Entities.Moniteur;
import yassine.tn.yassine_ski.Generic.IGenericService;
//import yassine.tn.yassine_ski.Generic.IGenericService;

import java.util.List;

public interface IMoniteurService extends IGenericService<Moniteur,Long> {
    List<Moniteur> retrieveAllMoniteurs();
    Moniteur addMoniteur(Moniteur moniteur);
    Moniteur updateMoniteur (Moniteur moniteur);
    Moniteur retrieveMoniteur (Long numMoniteur);
     Moniteur addInstructorAndAssignToCourse(Moniteur moniteur, Long numCourse);

    }
