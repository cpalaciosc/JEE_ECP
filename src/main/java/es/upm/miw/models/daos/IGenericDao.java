package es.upm.miw.models.daos;

import java.util.List;

public interface IGenericDao<T, ID> {

    void create(T entity);

    T read(ID id);

    void update(T entity);

    void deleteById(ID id);

    List<T> findAll();
    
    void deleteAll();

}
