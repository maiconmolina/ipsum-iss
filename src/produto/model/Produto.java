package produto.model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import lote.model.Lote;
import material.model.Material;


@Entity
public class Produto implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "COD_PRODUTO")
    private Integer codigo;
    
    @Column(name = "DESCRICAO")
    private String descricao;
    
    @Column(name = "PRECO")
    private Double preco;
    
    @ManyToMany //Mapeamento bidirecional
    @JoinTable(name="MATERIAIS_DO_PRODUTO", joinColumns={@JoinColumn(name="COD_PRODUTO")}, inverseJoinColumns={@JoinColumn(name="COD_MATERIAL")})
    private List<Material> materiais; 
    
    @ManyToMany(mappedBy = "produtos")
    private List<Lote> lotes;
    
    @Column(name = "ATIVO")
    private Boolean ativo;

    public Produto(Integer codigo) {
        this.codigo = codigo;
    }

    public Produto() {
        super();
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        Integer oldCodigo = this.codigo;
        this.codigo = codigo;
        changeSupport.firePropertyChange("codigo", oldCodigo, codigo);
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        String oldDescricao = this.descricao;
        this.descricao = descricao;
        changeSupport.firePropertyChange("descricao", oldDescricao, descricao);
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        Double oldPreco = this.preco;
        this.preco = preco;
        changeSupport.firePropertyChange("preco", oldPreco, preco);
    }

    public List<Material> getMateriais() {
        return materiais;
    }

    public void setMateriais(List<Material> materiais) {
        this.materiais = materiais;
    }

    public Boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        Boolean oldAtivo = this.ativo;
        this.ativo = ativo;
        changeSupport.firePropertyChange("ativo", oldAtivo, ativo);
    }

    public List<Lote> getLotes() {
        return lotes;
    }

    public void setLotes(List<Lote> lotes) {
        this.lotes = lotes;
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
            
}
