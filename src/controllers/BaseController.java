package controllers;

import Util.ReturnValidate;
import dao.implementacoes.Repositorio;
import entities.Entidade;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseController<T extends Entidade> {

    Repositorio<T, Integer> repo;

    public BaseController() {
        this.repo = new Repositorio<>();
    }

    public ReturnValidate save(T entity) {
        try {
            ReturnValidate retorno = this.isValidSave(entity);
            if (retorno.isValid()) {
                this.repo.save(entity);
            }
            return retorno;

        } catch (Exception ex) {
            ex.printStackTrace();
            return new ReturnValidate(ex.getMessage());
        }
    }

    public ReturnValidate inativa(T entity) {
        try {
            ReturnValidate retorno = this.isValidDelete(entity);
            if (retorno.isValid()) {
                this.repo.inativar(entity);
            }
            return retorno;

        } catch (Exception ex) {
            ex.printStackTrace();
            return new ReturnValidate(ex.getMessage());
        }
    }

    public List<T> getAll(Class<T> classe) {
        try {
            return this.repo.getAll(classe);

        } catch (Exception ex) {
            ex.printStackTrace();
            return new ArrayList<T>();
        }
    }

    public ReturnValidate reativa(T entity) {
        try {
            this.repo.reativar(entity);
            return new ReturnValidate(null);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ReturnValidate(ex.getMessage());
        }
    }

    public ReturnValidate getById(Class<T> classe, Integer id) {
        try {
            this.repo.getById(classe, id);
            return new ReturnValidate(null);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ReturnValidate(ex.getMessage());
        }
    }

    public ReturnValidate getAllActive(Class<T> classe) {
        try {
            this.repo.getAllActive(classe);
            return new ReturnValidate(null);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ReturnValidate(ex.getMessage());
        }
    }

    protected abstract ReturnValidate isValidSave(T entidade);

    protected abstract ReturnValidate isValidDelete(T entidade);

}
