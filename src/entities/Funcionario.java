package entities;

import enums.NivelHabilidade;
import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@PrimaryKeyJoinColumn(name = "codigo")
public class Funcionario extends Usuario {

    @Column(length = 255, name = "NOME", nullable = false)
    private String nome;

    @Column(name = "SALARIO", nullable = false)
    private Double salario;

    @Column(name = "DATA_NASCIMENTO", nullable = false)
    @Temporal(TemporalType.DATE)
    private Calendar dataNascimento;

    @Column(length = 11, name = "CPF", nullable = false)
    private String cpf;

    @Column(length = 25, name = "RG", nullable = false)
    private String rg;

    @Column(name = "TEMPORARIO", nullable = false)
    private boolean temporario;

    @Column(length = 10, name = "TELEFONE", nullable = false)
    private String telefone;

    @Column(name = "NIVEL_HABILIDADE", nullable = false)
    private NivelHabilidade nivel;

    @Column(length = 255, name = "ENDERECO", nullable = false)
    private String endereco;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "Funcao")
    private Funcao funcao;

//    @ManyToMany(mappedBy = "Lote", fetch = FetchType.EAGER)
//    @JoinColumn(name = "Lote")
//    private Collection<Lote> loteCollection;
}
