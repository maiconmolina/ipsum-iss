package funcao.model;

import Util.ReturnValidate;
import funcionario.controller.FuncionarioController;
import funcionario.model.Funcionario;
import java.util.ArrayList;
import java.util.List;
import persistencia.DAOImpl;

public class FuncaoDaoImpl extends DAOImpl<Funcao, Integer> implements FuncaoDAO {

    public List<Funcao> getAllActive() {
        List<Funcao> all = this.getAll(Funcao.class);
        List<Funcao> retorno = new ArrayList<>();
        for (Funcao f : all) {
            if (f.isAtivo()) {
                retorno.add(f);
            }
        }
        return retorno;
    }

    public ReturnValidate inativa(Integer cod) {
        Funcao funcao = this.getById(Funcao.class, cod);
        List<Funcionario> funcionarios = FuncionarioController.getFuncionariosAtivos();
        for (Funcionario f : funcionarios) {
            if (f.getFuncao().equals(funcao)) {
                return new ReturnValidate("Não é possível inativar pois existe"
                        + " um funcionário ativo cadastrado com essa função.");
            }
        }
        
        funcao.inativar();
        this.save(funcao);
        return new ReturnValidate(null);
    }

    public void reativa(Integer cod) {
        Funcao funcao = this.getById(Funcao.class, cod);
        funcao.reativar();
        this.save(funcao);
    }

}
