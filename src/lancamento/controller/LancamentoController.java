package lancamento.controller;

import Util.ReturnValidate;
import java.util.ArrayList;
import java.util.List;
import lancamento.model.Lancamento;
import lancamento.model.LancamentoDAOImpl;
//import lancamento.model.LancamentoDAO;

public class LancamentoController {

    public static ReturnValidate InsereLancamento(Lancamento lanc) {
        return lanc.save();
    }

    public static ReturnValidate Remove(Lancamento lanc) {
        return lanc.remove();
    }

    public static List<Lancamento> busca() {
        LancamentoDAOImpl lanc = new LancamentoDAOImpl();
        return lanc.getAll(Lancamento.class);
    }

    public static Lancamento buscaId(String id) {
        LancamentoDAOImpl lanc = new LancamentoDAOImpl();
        return lanc.getById(Lancamento.class, Integer.parseInt(id));
    }

}
