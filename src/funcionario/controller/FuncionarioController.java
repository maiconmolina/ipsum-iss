package funcionario.controller;

import Util.ReturnValidate;
import funcionario.model.Funcionario;

public class FuncionarioController {

    public static ReturnValidate InsereFuncionario(Funcionario func) {
        return func.save();
    }
}
