package yassine.tn.yassine_ski.service;

import yassine.tn.yassine_ski.Entities.Inscription;
import yassine.tn.yassine_ski.Generic.IGenericService;

import java.util.List;

public interface InscriptionService extends IGenericService<Inscription, Long> {
    List<Inscription>retrieveAllInscriptions();
    Inscription addInscription(Inscription inscription);
    Inscription updateInscription(Inscription inscription);
    Inscription retrieveInscription(Long numInscription);
    void deleteInscription(Long numInscription);
}
