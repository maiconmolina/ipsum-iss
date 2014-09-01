package lote.model;


import funcionario.model.Funcionario;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Calendar;
import java.util.List;
import javax.persistence.*;
import produto.model.Produto;


@Entity
public class Lote implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    
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
    
    @ManyToMany //Mapeamento bidirecional
    @JoinTable(name="FUNCIONARIOS_DO_LOTE", joinColumns={@JoinColumn(name="COD_LOTE")}, inverseJoinColumns={@JoinColumn(name="COD_FUNC")})
    private List<Funcionario> funcionarios; 

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        Integer oldCodigo = this.codigo;
        this.codigo = codigo;
        changeSupport.firePropertyChange("codigo", oldCodigo, codigo);
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
        Calendar oldDataLote = this.dataLote;
        this.dataLote = dataLote;
        changeSupport.firePropertyChange("dataLote", oldDataLote, dataLote);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
}
