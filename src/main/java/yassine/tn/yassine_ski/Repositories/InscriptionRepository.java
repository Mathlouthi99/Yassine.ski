package yassine.tn.yassine_ski.Repositories;

//import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import yassine.tn.yassine_ski.Entities.Inscription;

public interface InscriptionRepository extends CrudRepository<Inscription, Long> {

}