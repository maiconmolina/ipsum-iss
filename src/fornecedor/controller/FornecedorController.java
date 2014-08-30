package fornecedor.controller;

import Util.ReturnValidate;
import fornecedor.model.Fornecedor;

public class FornecedorController {

    public static ReturnValidate InsereFornecedor(Fornecedor forn) {
        return forn.save();
    }
}
