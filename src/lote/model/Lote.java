package lote.model;


import fornecedor.model.Fornecedor;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Collection;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import produto.model.ProdutoDoLote;


@Entity
@Table(name = "LOTE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Lote.findAll", query = "SELECT l FROM Lote l"),
    @NamedQuery(name = "Lote.findByCodlote", query = "SELECT l FROM Lote l WHERE l.codlote = :codlote"),
    @NamedQuery(name = "Lote.findByCodfornec", query = "SELECT l FROM Lote l WHERE l.codfornec = :codfornec")})
public class Lote implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @Column(name = "CODLOTE")
    private Integer codlote;
    
    /*@Column(name = "CODFORNEC")
    private Integer codfornec;*/
    
    @ManyToOne
    private Fornecedor fornec;
    
    /*@ManyToMany(mappedBy = "loteCollection")   
    private Collection<Funcionario> funcionarioCollection;*/
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "lote")
    private Collection<ProdutoDoLote> produtoDoLoteCollection;
    
    @Column(name = "dataLote")
    @Temporal(TemporalType.DATE)
    private Calendar dataLote;

    public Lote() {
    }

    public Integer getCodigo() {
        return codlote;
    }

    public void setCodigo(Integer codigo) {
        Integer oldCodigo = this.codlote;
        this.codlote = codigo;
        changeSupport.firePropertyChange("codigo", oldCodigo, codigo);
    }

    public Calendar getDataLote() {
        return dataLote;
    }

    public void setDataLote(Calendar dataLote) {
        Calendar oldDataLote = this.dataLote;
        this.dataLote = dataLote;
        changeSupport.firePropertyChange("dataLote", oldDataLote, dataLote);
    }
    
       /* public Integer getCodfornec() {
        return codfornec;
    }*/

    /*public void setCodfornec(Integer codfornec) {
        this.codfornec = codfornec;
    }*/

    /*@XmlTransient
    public Collection<Funcionario> getFuncionarioCollection() {
        return funcionarioCollection;
    }

    public void setFuncionarioCollection(Collection<Funcionario> funcionarioCollection) {
        this.funcionarioCollection = funcionarioCollection;
    }*/

    @XmlTransient
    public Collection<ProdutoDoLote> getProdutoDoLoteCollection() {
        return produtoDoLoteCollection;
    }

    public void setProdutoDoLoteCollection(Collection<ProdutoDoLote> produtoDoLoteCollection) {
        this.produtoDoLoteCollection = produtoDoLoteCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codlote != null ? codlote.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Lote)) {
            return false;
        }
        Lote other = (Lote) object;
        if ((this.codlote == null && other.codlote != null) || (this.codlote != null && !this.codlote.equals(other.codlote))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "lab.Lote[ codlote=" + codlote + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
}
