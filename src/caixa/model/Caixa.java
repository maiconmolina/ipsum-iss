package caixa.model;

import Util.ReturnValidate;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lancamento.controller.LancamentoController;
import lancamento.model.Lancamento;

@Entity
@Table(name = "Caixa")
public class Caixa implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer codigo;

    @Column(name = "SALDO", nullable = false)
    private static double saldo;

    @Column(length = 1, name = "STATUS", nullable = false)
    private static StatusCaixa status;
//
//    @OneToMany(cascade = CascadeType.ALL)
//    private List<Lancamento> lancamentos = new ArrayList<Lancamento>();

    public Caixa() {
        super();
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public static double getSaldo() {
        saldo = 0;
        List<Lancamento> lancamentos = LancamentoController.busca();
        for (Lancamento lanc : lancamentos) {
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

    public static StatusCaixa getStatus() {
        return status;
    }

    public static void setStatus(StatusCaixa status) {
        Caixa.status = status;
    }

    public ReturnValidate save() {
        ReturnValidate validacao = this.isValid();
        if (validacao.isValid()) {
            CaixaDAOImpl caixa = new CaixaDAOImpl();
            caixa.save(this);
        }
        return validacao;
    }

    public ReturnValidate isValid() {
        return new ReturnValidate("");
    }

}
