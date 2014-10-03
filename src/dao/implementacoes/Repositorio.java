package dao.implementacoes;

import dao.interfaces.BaseDao;
import entities.Entidade;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

public class Repositorio<T extends Entidade, I extends Serializable> implements BaseDao<T, I> {

    private Conexao conexao;

    @Override
    public T save(T entity) {

        T saved = null;

        getEntityManager().getTransaction().begin();
        saved = getEntityManager().merge(entity);
        getEntityManager().getTransaction().commit();

        return saved;
    }

    @Override
    public T getById(Class<T> classe, I pk) {
        try {
            return getEntityManager().find(classe, pk);
        } catch (NoResultException e) {
            return null;
        }

    }

    @SuppressWarnings("unchecked")
    @Override
    public List<T> getAll(Class<T> classe) {

        return getEntityManager().createQuery("select o from " + classe.getSimpleName() + " o").getResultList();
    }

    @Override
    public EntityManager getEntityManager() {

        if (conexao == null) {
            conexao = new Conexao();
        }
        return conexao.getEntityManager();
    }

    @Override
    public void inativar(T entity) {
        entity.setAtivo(false);
        this.save(entity);
    }

    @Override
    public void reativar(T entity) {
        entity.setAtivo(true);
        this.save(entity);
    }

    @Override
    public List<T> getAllActive(Class<T> classe) {
        List<T> retorno = new ArrayList<>();
        for (T entidade : this.getAll(classe)) {
            if (entidade.isAtivo()) {
                retorno.add(entidade);
            }
        }
        return retorno;
    }
}
