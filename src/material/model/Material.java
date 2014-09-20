/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package material.model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import produto.model.Produto;

/**
 *
 * @author Maicon
 */
@Entity
@Table(name = "MATERIAL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Material.findAll", query = "SELECT m FROM Material m"),
    @NamedQuery(name = "Material.findByCodmat", query = "SELECT m FROM Material m WHERE m.codmat = :codmat"),
    @NamedQuery(name = "Material.findByQtde", query = "SELECT m FROM Material m WHERE m.qtde = :qtde")})
public class Material implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "COD_MATERIAL")
    private Integer codmat;
    
    @Column(name = "DESCRICAO")
    private String descricao;
    
    @Column(name = "PRECO")
    private Double preco;
    
    /*@ManyToMany(mappedBy = "materiais")
    private List<Produto> produtos;*/
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "material")
    private Collection<MaterialDoProduto> materialDoProdutoCollection;
    
    @Column(name = "ATIVO")
    private Boolean ativo = Boolean.TRUE;
    
    @Column(name = "QTDE")
    private Integer qtde;
    
    public Material(Integer codigo, String descricao, Double preco) {
        this.codmat = codigo;
        this.ativo = Boolean.TRUE;
        this.descricao = descricao;
        this.preco = preco;
    }

    public Material() {
        super();
    }
    
    public Integer getQtde() {
        return qtde;
    }

    public void setQtde(Integer qtde) {
        this.qtde = qtde;
    }

    public Integer getCodigo() {
        return codmat;
    }

    public void setCodigo(Integer codigo) {
        Integer oldCodigo = this.codmat;
        this.codmat = codigo;
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

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
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
        hash += (codmat != null ? codmat.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Material)) {
            return false;
        }
        Material other = (Material) object;
        if ((this.codmat == null && other.codmat != null) || (this.codmat != null && !this.codmat.equals(other.codmat))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "teste.Material[ codmat=" + codmat + " ]";
    }
}
