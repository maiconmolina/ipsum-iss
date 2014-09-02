package fornecedor.model;


import java.util.ArrayList;
import java.util.List;
import persistencia.DAOImpl;


public class FornecedorDAOImpl extends DAOImpl<Fornecedor, Integer> implements FornecedorDAO{
    public List<Fornecedor> getAllActive() {
        List<Fornecedor> all = this.getAll(Fornecedor.class);
        List<Fornecedor> retorno = new ArrayList<>();
        for (Fornecedor f : all) {
            if (f.isAtivo()) {
                retorno.add(f);
            }
        }
        return retorno;
    }
}