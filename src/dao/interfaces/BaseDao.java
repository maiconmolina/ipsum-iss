package dao.interfaces;

import entities.Entidade;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;

public interface BaseDao<T extends Entidade, I extends Serializable> {

    public T save(T entity);

    public void inativar(T entity);
    
    public void reativar(T entity);

    public T getById(Class<T> classe, I pk);

    public List<T> getAll(Class<T> classe);

    public List<T> getAllActive(Class<T> classe);

    public EntityManager getEntityManager();
}
