/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lancamento.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Lancamento {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer Codigo;

    @Column(length = 1, name = "TIPO", nullable = false)
    private TipoDeLancamento tipo;

    @Column(name = "VALOR", nullable = false)
    private Double valor;

    @Column(length = 500, name = "DESCRICAO", nullable = false)
    private String descricao;

    public Lancamento() {
        super();
    }

    public Integer getCodigo() {
        return Codigo;
    }

    public void setCodigo(Integer Codigo) {
        this.Codigo = Codigo;
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    

}
