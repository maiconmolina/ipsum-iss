package funcionario.model;

import java.util.ArrayList;
import java.util.List;
import persistencia.DAOImpl;

public class FuncionarioDaoImpl extends DAOImpl<Funcionario, Integer> implements FuncionarioDAO {

    public List<Funcionario> getAllActive() {
        List<Funcionario> all = this.getAll(Funcionario.class);
        List<Funcionario> retorno = new ArrayList<>();
        for (Funcionario f : all) {
            if (f.isAtivo()) {
                retorno.add(f);
            }
        }
        return retorno;
    }

}
