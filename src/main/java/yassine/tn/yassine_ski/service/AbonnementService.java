package yassine.tn.yassine_ski.service;

import yassine.tn.yassine_ski.Entities.Abonnement;

import java.util.List;

public interface AbonnementService {

    Abonnement add(Abonnement abonnement);

    Abonnement update(Abonnement abonnement);

    Abonnement getById(long id);

    List<Abonnement> getAll();

    boolean remove(long id);
}
