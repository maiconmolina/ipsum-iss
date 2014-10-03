package controllers;

import Util.ReturnValidate;
import entities.Funcionario;

public class FuncionarioController extends BaseController<Funcionario>{

    @Override
    protected ReturnValidate isValidSave(Funcionario entidade) {
        StringBuilder retorno = new StringBuilder();
        
        return new ReturnValidate(retorno.toString());
    }

    @Override
    protected ReturnValidate isValidDelete(Funcionario entidade) {
        StringBuilder retorno = new StringBuilder();
        
        return new ReturnValidate(retorno.toString());
    }
    
}
