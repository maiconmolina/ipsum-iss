package caixa.model;

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
import lancamento.model.Lancamento;

@Entity
@Table(name = "Caixa")
public class Caixa {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer codigo;

    @Column(name = "SALDO", nullable = false)
    private static double saldo;

    @Column(length = 1, name = "STATUS", nullable = false)
    private static StatusCaixa status;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Lancamento> lancamentos = new ArrayList<Lancamento>();

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
        return saldo;
    }

    public static void setSaldo(double saldo) {
        Caixa.saldo = saldo;
    }

    public static StatusCaixa getStatus() {
        return status;
    }

    public static void setStatus(StatusCaixa status) {
        Caixa.status = status;
    }

}
