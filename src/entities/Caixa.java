package entities;

import enums.StatusCaixa;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Caixa extends Entidade implements Serializable {

    @Column(name = "SALDO", nullable = false)
    private double saldo;

    @Column(length = 1, name = "STATUS", nullable = false)
    private StatusCaixa status;

    //    @OneToMany(cascade = CascadeType.ALL)
    //    private List<Lancamento> lancamentos = new ArrayList<Lancamento>();
    public Caixa() {
        super();
        codigo = 1;
    }
    
    
    
}
