package yassine.tn.yassine_ski.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import yassine.tn.yassine_ski.Entities.Cours;
import yassine.tn.yassine_ski.Entities.Skieur;
import yassine.tn.yassine_ski.Repositories.CoursRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ICoursServiceImpl implements ICoursService {

    @Autowired
    private CoursRepository coursRepository;

    @Autowired
    public ICoursServiceImpl(CoursRepository coursRepository) {
        this.coursRepository = coursRepository;
    }

    @Override
    public List<Cours> retrieveAllCourses() {
        return (List<Cours>) coursRepository.findAll();
    }

    @Override
    public Cours addCours(Cours cours) {
        return coursRepository.save(cours);
    }

    @Override
    public Cours updateCours(Cours cours) {
        return coursRepository.save(cours);
    }

    @Override
    public Cours retrieveCours(Long numCours) {
        Optional<Cours> coursOptional = coursRepository.findById(numCours);
        return coursOptional.orElse(null);
    }
    @Override
    public List<Cours> findAvailableCoursForSkieur(Skieur skieur) {
        // Retrieve all courses
        return (List<Cours>) coursRepository.findAll();

    }


}

