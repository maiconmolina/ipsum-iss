package produto.model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Collection;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import material.model.MaterialDoProduto;


@Entity
@Table(name = "PRODUTO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Produto.findAll", query = "SELECT p FROM Produto p"),
    @NamedQuery(name = "Produto.findByCodprod", query = "SELECT p FROM Produto p WHERE p.codprod = :codprod")})
public class Produto implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @Column(name = "CODPROD")
    private Integer codprod;
    
    @Lob
    @Column(name = "DESCRICAO")
    private String descricao;
    
    @Column(name = "PRECO")
    private Double preco;
    
    /*@ManyToMany //Mapeamento bidirecional
    @JoinTable(name="MATERIAIS_DO_PRODUTO", joinColumns={@JoinColumn(name="COD_PRODUTO")}, inverseJoinColumns={@JoinColumn(name="COD_MATERIAL")})
    private List<Material> materiais; 
    
    @ManyToMany(mappedBy = "produtos")
    private List<Lote> lotes;*/
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "produto")
    private Collection<ProdutoDoLote> produtoDoLoteCollection;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "produto")
    private Collection<MaterialDoProduto> materialDoProdutoCollection;
    
    @Column(name = "ATIVO")
    private Boolean ativo;

    public Produto(Integer codigo) {
        this.codprod = codigo;
    }

    public Produto() {
        super();
    }

    public Integer getCodigo() {
        return codprod;
    }

    public void setCodigo(Integer codigo) {
        Integer oldCodigo = this.codprod;
        this.codprod = codigo;
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

    public Boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        Boolean oldAtivo = this.ativo;
        this.ativo = ativo;
        changeSupport.firePropertyChange("ativo", oldAtivo, ativo);
    }
    
    @XmlTransient
    public Collection<ProdutoDoLote> getProdutoDoLoteCollection() {
        return produtoDoLoteCollection;
    }

    public void setProdutoDoLoteCollection(Collection<ProdutoDoLote> produtoDoLoteCollection) {
        this.produtoDoLoteCollection = produtoDoLoteCollection;
    }

    @XmlTransient
    public Collection<MaterialDoProduto> getMaterialDoProdutoCollection() {
        return materialDoProdutoCollection;
    }

    public void setMaterialDoProdutoCollection(Collection<MaterialDoProduto> materialDoProdutoCollection) {
        this.materialDoProdutoCollection = materialDoProdutoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codprod != null ? codprod.hashCode() : 0);
        return hash;
    }
    
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Produto)) {
            return false;
        }
        Produto other = (Produto) object;
        if ((this.codprod == null && other.codprod != null) || (this.codprod != null && !this.codprod.equals(other.codprod))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "teste.Produto[ codprod=" + codprod + " ]";
    }
    

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
            
}
