package caixa.controller;

import Util.ReturnValidate;
import caixa.model.Caixa;
import java.util.ArrayList;
import java.util.List;
import lancamento.controller.LancamentoController;
import lancamento.model.Lancamento;

public class CaixaController {

    public static ReturnValidate InsereCaixa(Caixa caixa) {
        return caixa.save();
    }


    public static double consultaSaldo() {
        LancamentoController lancaController = new LancamentoController();
        double saldo = 0;
        List<Lancamento> Listlanc = lancaController.busca();
        for (Lancamento lanc : Listlanc) {
            if (lanc.getTipo().toString().equals("Entrada")) {
                saldo = saldo + lanc.getValor();
            } else {
                if (lanc.getTipo().toString().equals("Saída")) {
                    saldo = saldo - lanc.getValor();
                }
            }
        }
        return saldo;
    }
}
