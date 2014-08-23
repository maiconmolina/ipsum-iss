package lote.model;


import java.util.GregorianCalendar;
import java.util.List;
import produto.model.Produto;
import javax.persistence.*;


@Entity
public class Lote {
    
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

    public Lote(Integer codigo, List<Produto> produtos, GregorianCalendar dataLote) {
        this.codigo = codigo;
        this.produtos = produtos;
        this.dataLote = dataLote;
    }
    
    @Column(name = "dataLote")
    private GregorianCalendar dataLote;

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

    public GregorianCalendar getDataLote() {
        return dataLote;
    }

    public void setDataLote(GregorianCalendar dataLote) {
        this.dataLote = dataLote;
    }
}
