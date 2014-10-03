/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package situacaolancamento.model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import entities.Lancamento;
import lancamento.model.SituacaoLancamentoPK;

@Entity
@Table(name = "SITUACAO_LANCAMENTO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SituacaoLancamento.findAll", query = "SELECT s FROM SituacaoLancamento s"),
    @NamedQuery(name = "SituacaoLancamento.findByCodsit", query = "SELECT s FROM SituacaoLancamento s WHERE s.situacaoLancamentoPK.codsit = :codsit"),
    @NamedQuery(name = "SituacaoLancamento.findByCodlanc", query = "SELECT s FROM SituacaoLancamento s WHERE s.situacaoLancamentoPK.codlanc = :codlanc"),
    @NamedQuery(name = "SituacaoLancamento.findByData", query = "SELECT s FROM SituacaoLancamento s WHERE s.data = :data")})
public class SituacaoLancamento implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SituacaoLancamentoPK situacaoLancamentoPK;
    @Column(name = "DATA")
    @Temporal(TemporalType.DATE)
    private Date data;

    @JoinColumn(name = "CODLANC", referencedColumnName = "CODLANC", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Lancamento lancamento;

    @Column(length = 1, name = "STATUS", nullable = false)
    private SituacaoLancamento status;

    public SituacaoLancamento() {
        super();
        Calendar cal = Calendar.getInstance();
//        this.data = cal;
    }

    public SituacaoLancamento getStatus() {
        return status;
    }

    public void setStatus(SituacaoLancamento status) {
        this.status = status;
    }

}
