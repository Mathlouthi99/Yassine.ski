package yassine.tn.yassine_ski.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import yassine.tn.yassine_ski.Entities.Inscription;
import yassine.tn.yassine_ski.Repositories.InscriptionRepository;
import yassine.tn.yassine_ski.service.InscriptionService;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class InscriptionServiceImpl implements InscriptionService {

    @Autowired
    private InscriptionRepository inscriptionRepository;

    @Override
    public List<Inscription> retrieveAllInscriptions() {
        return (List<Inscription>) inscriptionRepository.findAll();
    }

    @Override
    public Inscription addInscription(Inscription inscription) {
        return inscriptionRepository.save(inscription);
    }

    @Override
    public Inscription updateInscription(Inscription inscription) {
        return inscriptionRepository.save(inscription);
    }

    @Override
    public Inscription retrieveInscription(Long numInscription) {
        Optional<Inscription> optionalInscription = inscriptionRepository.findById(numInscription);
        return optionalInscription.orElse(null);
    }

    @Override
    public void deleteInscription(Long numInscription) {
        inscriptionRepository.deleteById(numInscription);
    }

    @Override
    public Inscription add(Inscription entity) {
        return inscriptionRepository.save(entity);
    }

    @Override
    public Inscription update(Inscription entity) {
        return inscriptionRepository.save(entity);
    }

    @Override
    public Inscription retrieveById(Long aLong) {
        Optional<Inscription> optionalInscription = inscriptionRepository.findById(aLong);
        return optionalInscription.orElse(null);
    }

    @Override
    public List<Inscription> retrieveAll() {
        return (List<Inscription>) inscriptionRepository.findAll();
    }

    @Override
    public Boolean delete(Long aLong) {
        Optional<Inscription> optionalInscription = inscriptionRepository.findById(aLong);
        if (optionalInscription.isPresent()) {
            inscriptionRepository.delete(optionalInscription.get());
            return true;
        }
        return false;
    }
}
