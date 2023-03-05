package yassine.tn.yassine_ski.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import yassine.tn.yassine_ski.Entities.Cours;
import yassine.tn.yassine_ski.Entities.Moniteur;
import yassine.tn.yassine_ski.Generic.IGenericServiceImp;
import yassine.tn.yassine_ski.Repositories.CoursRepository;
import yassine.tn.yassine_ski.Repositories.MoniteurRepository;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;
import java.util.Optional;

@Service
public class IMoniteurServiceImpl extends IGenericServiceImp<Moniteur,Long> implements IMoniteurService {


    @Autowired
    private MoniteurRepository moniteurRepository;
    @Autowired
    private CoursRepository coursRepository;


    @Override
    public List<Moniteur> retrieveAllMoniteurs() {
        return this.retrieveAll();
    }

    @Override
    public Moniteur addMoniteur(Moniteur moniteur) {
        return this.add(moniteur);
    }

    @Override
    public Moniteur updateMoniteur(Moniteur moniteur) {
        return this.update(moniteur);
    }

    @Override
    public Moniteur retrieveMoniteur(Long numMoniteur) {
        return this.retrieveById(numMoniteur);
    }

    public Moniteur addInstructorAndAssignToCourse(Moniteur moniteur, Long numCourse) {
        // retrieve the course by ID
        Cours course = coursRepository.findById(numCourse).orElse(null);

        if (course == null) {
            // course not found
            return null;
        }

        // assign the moniteur to the course
        moniteur.getCours().add(course);
        course.setMoniteur(moniteur);

        // save the changes to the database
        moniteurRepository.save(moniteur);
        coursRepository.save(course);

        // return the updated moniteur
        return moniteur;
    }


}
