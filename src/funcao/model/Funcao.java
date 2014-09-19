package funcao.model;

import Util.RemovableLogically;
import Util.ReturnValidate;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Funcao implements Serializable, RemovableLogically {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "CODIGO")
    private Integer codigo;

    @Column(length = 255, name = "NOME_FUNCAO", nullable = false)
    private String nomeFuncao;

    @Column(name = "ATIVO", nullable = false)
    private Boolean ativo;

    public Funcao() {
        this.codigo = null;
        this.nomeFuncao = "";
        this.ativo = true;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNomeFuncao() {
        return nomeFuncao;
    }

    public void setNomeFuncao(String nomeFuncao) {
        this.nomeFuncao = nomeFuncao;
    }

    @Override
    public ReturnValidate inativar() {
        this.ativo = false;
        return null;
    }

    @Override
    public ReturnValidate reativar() {
        this.ativo = true;
        return null;
    }

    @Override
    public Boolean isAtivo() {
        return this.ativo;
    }
    
    @Override
    public String toString(){
        return this.nomeFuncao;
    }
}
