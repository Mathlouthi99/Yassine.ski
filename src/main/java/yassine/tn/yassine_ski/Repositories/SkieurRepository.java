package yassine.tn.yassine_ski.Repositories;

//import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import yassine.tn.yassine_ski.Entities.Skieur;

@Repository

public interface SkieurRepository extends CrudRepository<Skieur, Long> {
    // no need to add anything here, the basic CRUD operations are already defined in CrudRepository
}

