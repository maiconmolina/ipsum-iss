/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package material.controller;

import java.util.Collection;
import javax.persistence.EntityManager;
import javax.persistence.RollbackException;
import material.model.Material;
import material.model.MaterialDAOImpl;

/**
 *
 * @author Maicon
 */
public class MaterialController {

    private static final MaterialDAOImpl dao = new MaterialDAOImpl();

    public MaterialController() {
        super();
    }

    public Material salvar(Material m) {
        return dao.save(m);
    }

    public void remover(Material m) {
        dao.remove(m);
    }

    public void atualiza(Collection c) {
        try {
            dao.getEntityManager().getTransaction().rollback();
            dao.getEntityManager().getTransaction().commit();
        } catch (RollbackException e) {
            dao.getEntityManager().getTransaction().begin();
            for (Object o : c) {
                dao.getEntityManager().refresh(o);
            }
            dao.getEntityManager().getTransaction().commit();
        } catch (Exception e){
            e.printStackTrace();
        }
        

    }

    public Material buscarporId(Integer i) {
        return dao.getById(i);
    }

    public EntityManager getEM() {
        return dao.getEntityManager();
    }

}
