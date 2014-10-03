package entities;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import produto.model.ProdutoDoLote;

@Entity
public class Lote extends Entidade implements Serializable {

    @ManyToOne(fetch = FetchType.EAGER)
    private Fornecedor fornec;

//    @ManyToMany(mappedBy = "loteCollection")   
//    private Collection<Funcionario> funcionarioCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "lote")
    private Collection<ProdutoDoLote> produtoDoLoteCollection;

    @Column(name = "dataLote")
    @Temporal(TemporalType.DATE)
    private Calendar dataLote;
}
