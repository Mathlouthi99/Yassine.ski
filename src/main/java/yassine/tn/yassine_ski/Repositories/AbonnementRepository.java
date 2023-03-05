package yassine.tn.yassine_ski.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.CrudRepository;
import yassine.tn.yassine_ski.Entities.Abonnement;

public interface AbonnementRepository extends CrudRepository<Abonnement, Long> {

}