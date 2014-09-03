package fornecedor.controller;

import Util.ReturnValidate;
import fornecedor.model.Fornecedor;
import fornecedor.model.FornecedorDAOImpl;
import java.util.List;

public class FornecedorController {

    public static ReturnValidate InsereFornecedor(Fornecedor forn) {
       return forn.save();
    }
    
    public static List<Fornecedor> getUsuariosAtivos() {
        FornecedorDAOImpl forn = new FornecedorDAOImpl();
        return forn.getAllActive();
    }

    public static ReturnValidate Inativar(Integer codigo) {
        Fornecedor forn = Fornecedor.getByCodigo(codigo);
        forn.inativar();
        return forn.save();
    }

    public static ReturnValidate Reativar(Integer codigo) {
        Fornecedor forn = Fornecedor.getByCodigo(codigo);
        forn.reativar();
        return forn.save();
    }

    public static List<Fornecedor> getUsuarios() {
        FornecedorDAOImpl forn = new FornecedorDAOImpl();
        return forn.getAll(Fornecedor.class);
    }
}
