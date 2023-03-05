package yassine.tn.yassine_ski.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import yassine.tn.yassine_ski.Entities.Abonnement;
import yassine.tn.yassine_ski.Repositories.AbonnementRepository;

import java.util.List;

@Service
public class AbonnementServiceImpl implements AbonnementService {


    @Autowired
    private  AbonnementRepository abonnementRepository;

    @Autowired
    public AbonnementServiceImpl(AbonnementRepository abonnementRepository) {
        this.abonnementRepository = abonnementRepository;
    }

    @Override
    public Abonnement add(Abonnement abonnement) {
        return abonnementRepository.save(abonnement);
    }

    @Override
    public Abonnement update(Abonnement abonnement) {
        return abonnementRepository.save(abonnement);
    }

    @Override
    public Abonnement getById(long id) {
        return abonnementRepository.findById(id).orElse(null);
    }

    @Override
    public List<Abonnement> getAll() {
        return (List<Abonnement>) abonnementRepository.findAll();
    }

    @Override
    public boolean remove(long id) {
        if (abonnementRepository.existsById(id)) {
            abonnementRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
