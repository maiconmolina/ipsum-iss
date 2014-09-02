package fornecedor.controller;

import Util.ReturnValidate;
import fornecedor.model.Fornecedor;
import java.util.List;

public class FornecedorController {

    public static ReturnValidate InsereFornecedor(Fornecedor forn) {
        return forn.save();
    }
    public static List<Fornecedor> getUsuariosAtivos() {
        return Fornecedor.getAllActive();//VOLTAR PRO GET ALL ATIVO
    }

    public static ReturnValidate Inativar(Integer codigo) {
        Fornecedor func = Fornecedor.getByCodigo(codigo);
        return func.inativar();
    }

    public static ReturnValidate Reativar(Integer codigo) {
        Fornecedor func = Fornecedor.getByCodigo(codigo);
        return func.reativar();
    }

    public static List<Fornecedor> getUsuarios() {
        return Fornecedor.getAll();
    }
}
