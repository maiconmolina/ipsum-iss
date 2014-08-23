package funcionario.controller;

import Util.ReturnValidate;
import Util.Util;
import funcionario.model.Funcionario;
import funcionario.model.FuncionarioDaoImpl;
import usuario.controller.UsuarioController;

public class FuncionarioController {

    public static ReturnValidate InsereFuncionario(Funcionario func) {
        String retorno = "";
        if (func.getNome().equals("")) {
            retorno += "Campo 'Nome' não pode ser vazio\n";
        }
        if (func.getDataNascimento() == null) {
            retorno += "Campo 'Data Nasc.' inválido\n";
        }
        if (!Util.ValidateCpf(func.getCpf())) {
            retorno += "CPF inválido\n";
        }
        if (func.getRg().equals("")) {
            retorno += "Campo 'RG' não pode ser vazio\n";
        }
        if (!Util.isNumeric(func.getRg())) {
            retorno += "Campo 'RG' inválido\n";
        }
        if (func.getTelefone().equals("")) {
            retorno += "Campo 'Telefone' não pode ser vazio\n";
        }
        if (func.getEndereco().equals("")) {
            retorno += "Campo 'Endereço' não pode ser vazio\n";
        }
        if (func.getSalario() <= 0) {
            retorno += "Campo 'Salário' inválido\n";
        }
        ReturnValidate validacaoUsuario = UsuarioController.InsereUsuario(func);
        if (!validacaoUsuario.isValid()) {
            retorno += validacaoUsuario.getMessage();
        }
        if (retorno.equals("")) {
            FuncionarioDaoImpl a = new FuncionarioDaoImpl();
            a.save(func);
        }
        return new ReturnValidate(retorno);
    }
}
