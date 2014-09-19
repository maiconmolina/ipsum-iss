package funcionario.controller;

import Util.ReturnValidate;
import funcionario.model.Funcionario;
import funcionario.model.FuncionarioDaoImpl;
import java.util.List;

public class FuncionarioController {

    public static ReturnValidate InsereFuncionario(Funcionario func) {
        return func.save();
    }

    public static List<Funcionario> getFuncionariosAtivos() {
        FuncionarioDaoImpl func = new FuncionarioDaoImpl();
        return func.getAllActive();
    }

    public static ReturnValidate Inativar(Integer codigo) {
        Funcionario func = Funcionario.getByCodigo(codigo);
        func.inativar();
        return func.save();
    }

    public static ReturnValidate Reativar(Integer codigo) {
        Funcionario func = Funcionario.getByCodigo(codigo);
        func.reativar();
        return func.save();
    }

    public static List<Funcionario> getFuncionarios() {
        FuncionarioDaoImpl func = new FuncionarioDaoImpl();
        return func.getAll(Funcionario.class);
    }
}
