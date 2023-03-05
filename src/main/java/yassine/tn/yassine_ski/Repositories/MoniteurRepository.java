package yassine.tn.yassine_ski.Repositories;

//import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import yassine.tn.yassine_ski.Entities.Moniteur;

@Repository

public interface MoniteurRepository extends CrudRepository<Moniteur, Long> {

}