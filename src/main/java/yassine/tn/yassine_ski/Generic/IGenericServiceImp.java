package yassine.tn.yassine_ski.Generic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.*;

public class IGenericServiceImp<T, ID> implements IGenericService<T, ID> {


    @Autowired
    private CrudRepository<T, ID> baseRepository;


    @Override
    public T add(T entity) {
        return (T) baseRepository.save(entity);
    }

    @Override
    public T update(T entity) {
        return (T) baseRepository.save(entity);
    }

    @Override
    public T retrieveById(ID id) {
        return (T) baseRepository.findById(id).orElse(null);
    }

    @Override
    public List<T> retrieveAll() {
        return (List<T>) baseRepository.findAll();
    }


    @Override
    public Boolean delete(ID id) {
        if (baseRepository.existsById(id)) {
            baseRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
