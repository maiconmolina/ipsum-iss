package lancamento.controller;

import Util.ReturnValidate;
import Util.Util;
import lancamento.model.Lancamento;
import lancamento.model.LancamentoDAO;

public class LancamentoController {

    public static ReturnValidate InsereLancamento(Lancamento lanc) {
        String retorno = "";
        if ("".equals(lanc.getDescricao())) {
            retorno += "Campo 'Descrição' não pode ser vazio\n";
        }
        if (lanc.getValor() <= 0) {
            retorno += "Campo 'Valor' inválido\n";
        }

        return new ReturnValidate(retorno);
    }

}
