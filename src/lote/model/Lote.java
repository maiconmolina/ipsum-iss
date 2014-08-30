package lote.model;


import java.io.Serializable;
import java.util.Calendar;
import java.util.List;
import produto.model.Produto;
import javax.persistence.*;


@Entity
public class Lote implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "COD_LOTE")
    private Integer codigo;
    
    @ManyToMany //Mapeamento bidirecional
    @JoinTable(name="PRODUTOS_LOTE", joinColumns={@JoinColumn(name="COD_LOTE")}, inverseJoinColumns={@JoinColumn(name="COD_PRODUTO")})
    private List<Produto> produtos;

    public Lote() {
        super();
    }

    public Lote(Integer codigo, List<Produto> produtos, Calendar dataLote) {
        this.codigo = codigo;
        this.produtos = produtos;
        this.dataLote = dataLote;
    }
    
    @Column(name = "dataLote")
    @Temporal(TemporalType.DATE)
    private Calendar dataLote;

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public Calendar getDataLote() {
        return dataLote;
    }

    public void setDataLote(Calendar dataLote) {
        this.dataLote = dataLote;
    }
}
