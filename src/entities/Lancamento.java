package entities;

import enums.TipoLancamento;
import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Lancamento extends Entidade implements Serializable {

    @Column(length = 1, name = "TIPO", nullable = false)
    private TipoLancamento tipo;

    @Column(name = "STATUS", nullable = true)
    private Boolean status;

    @Column(name = "CODIGOTIPO", nullable = true)
    private int codigoTipo;

    @Column(name = "VALOR", nullable = false)
    private Double valor;

    @Column(length = 500, name = "DESCRICAO", nullable = false)
    private String descricao;

    @Temporal(TemporalType.DATE)
    private Calendar dataInsercao;

//    @OneToMany(mappedBy = "lancamento")
//    private Collection<SituacaoLancamento> historico;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "lancamento")
//    private Collection<SituacaoLancamento> situacaoLancamentoCollection;
}
