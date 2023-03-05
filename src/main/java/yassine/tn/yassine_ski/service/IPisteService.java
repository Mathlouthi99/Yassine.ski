package yassine.tn.yassine_ski.service;

import yassine.tn.yassine_ski.Entities.Piste;

import java.util.List;

public interface IPisteService {

    List<Piste> retrieveAllPistes();
    Piste addPiste(Piste piste);
    Piste updatePiste(Piste piste);
    Piste retrievePiste(Long numPiste);
    void deletePiste(Long numPiste);
}