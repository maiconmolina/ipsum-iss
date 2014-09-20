/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lancamento.model;

import Util.ReturnValidate;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import situacaolancamento.model.SituacaoLancamento;

@Entity
@Table(name = "LANCAMENTO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Lancamento.findAll", query = "SELECT l FROM Lancamento l"),
    @NamedQuery(name = "Lancamento.findByCodlanc", query = "SELECT l FROM Lancamento l WHERE l.codlanc = :codlanc")})
public class Lancamento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODLANC")
    private Integer codlanc;

    @Column(length = 1, name = "TIPO", nullable = false)
    private TipoDeLancamento tipo;

    @Column(name = "STATUS", nullable = true)
    private Boolean status;

    @Column(name = "CODIGOTIPO", nullable = true)
    private int codigoTipo;

    @Column(name = "VALOR", nullable = false)
    private Double valor;

    @Column(length = 500, name = "DESCRICAO", nullable = false)
    private String descricao;

//    
//    @OneToMany(mappedBy = "lancamento")
//    private Collection<SituacaoLancamento> historico;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "lancamento")
    private Collection<SituacaoLancamento> situacaoLancamentoCollection;
    
    @Temporal(TemporalType.DATE)
    private Calendar dataInsercao;

    public Lancamento() {
        super();
        this.status = true;
    }

    public Integer getCodigo() {
        return codlanc;
    }

    public void setCodigo(Integer Codigo) {
        this.codlanc = Codigo;
    }

    public TipoDeLancamento getTipo() {
        return tipo;
    }

    public void setTipo(TipoDeLancamento tipo) {
        this.tipo = tipo;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public void setValor(String valor) {
        if ("".equals(valor)) {
            this.valor = 0.0;
        } else {
            valor = valor.replace(",", ".");
            Double valorDouble = Double.parseDouble(valor);
            this.valor = valorDouble;
        }
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public ReturnValidate save() {
        ReturnValidate validacao = this.isValid();
        if (validacao.isValid()) {
            LancamentoDAOImpl lanc = new LancamentoDAOImpl();
            lanc.save(this);
        }
        return validacao;
    }

    public ReturnValidate remove() {
        ReturnValidate validacao = this.isValid();
        if (validacao.isValid()) {
            LancamentoDAOImpl lanc = new LancamentoDAOImpl();
            lanc.remove(this);
        }
        return validacao;
    }

    public ReturnValidate isValid() {
        return new ReturnValidate("");
    }

//    public Calendar getData() {
//        return data;
//    }
//
//    public void setData(Calendar data) {
//        this.data = data;
//    }
    public Boolean isStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public int getCodigoTipo() {
        return codigoTipo;
    }

    public void setCodigoTipo(int codigoTipo) {
        this.codigoTipo = codigoTipo;
    }

    public Calendar getData() {
        return dataInsercao;
    }

    public void setData(Calendar data) {
        this.dataInsercao = data;
    }

//    @XmlTransient
//    public Collection<SituacaoLancamento> getSituacaoLancamentoCollection() {
//        return situacaoLancamentoCollection;
//    }
//
//    public void setSituacaoLancamentoCollection(Collection<SituacaoLancamento> situacaoLancamentoCollection) {
//        this.situacaoLancamentoCollection = situacaoLancamentoCollection;
//    }
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codlanc != null ? codlanc.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Lancamento)) {
            return false;
        }
        Lancamento other = (Lancamento) object;
        if ((this.codlanc == null && other.codlanc != null) || (this.codlanc != null && !this.codlanc.equals(other.codlanc))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "lab.Lancamento[ codlanc=" + codlanc + " ]";
    }

}
