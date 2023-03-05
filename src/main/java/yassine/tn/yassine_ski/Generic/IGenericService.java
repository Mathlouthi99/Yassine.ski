package yassine.tn.yassine_ski.Generic;


import java.util.List;

public interface IGenericService<T,ID> {

    T add(T entity);
    T update(T entity);
    T retrieveById(ID id);
    List<T> retrieveAll();
    Boolean delete(ID id);

}