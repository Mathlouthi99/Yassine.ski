package yassine.tn.yassine_ski.service;

import yassine.tn.yassine_ski.Entities.Piste;
import yassine.tn.yassine_ski.Repositories.PisteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import yassine.tn.yassine_ski.service.IPisteService;

import java.util.List;

@Service
public class IPistServiceImpl implements IPisteService {

    @Autowired
    private PisteRepository pisteRepository;

    @Override
    public List<Piste> retrieveAllPistes() {
        return (List<Piste>) pisteRepository.findAll();
    }

    @Override
    public Piste addPiste(Piste piste) {
        return pisteRepository.save(piste);
    }

    @Override
    public Piste updatePiste(Piste piste) {
        return pisteRepository.save(piste);
    }

    @Override
    public Piste retrievePiste(Long numPiste) {
        return pisteRepository.findById(numPiste).orElse(null);
    }

    @Override
    public void deletePiste(Long numPiste) {
        pisteRepository.deleteById(numPiste);
    }
}
