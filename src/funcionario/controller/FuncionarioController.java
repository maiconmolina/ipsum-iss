package funcionario.controller;

import Util.ReturnValidate;
import funcionario.model.Funcionario;
import java.util.List;

public class FuncionarioController {

    public static ReturnValidate InsereFuncionario(Funcionario func) {
        return func.save();
    }

    public static List<Funcionario> getUsuariosAtivos() {
        return Funcionario.getAllActive();//VOLTAR PRO GET ALL ATIVO
    }

    public static ReturnValidate Inativar(Integer codigo) {
        Funcionario func = Funcionario.getByCodigo(codigo);
        return func.inativar();
    }

    public static ReturnValidate Reativar(Integer codigo) {
        Funcionario func = Funcionario.getByCodigo(codigo);
        return func.reativar();
    }

    public static List<Funcionario> getUsuarios() {
        return Funcionario.getAll();
    }
}
