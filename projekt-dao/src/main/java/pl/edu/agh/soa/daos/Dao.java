package pl.edu.agh.soa.daos;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import java.util.List;

public interface Dao<E, I> {
    void create(E entity);
    void remove(E entity);
    void flush();
    E findById(I id);
    List<E> findAll();
}