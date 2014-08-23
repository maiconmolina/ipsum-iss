/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package material.model;

import java.util.List;
import javax.persistence.*;
import produto.model.Produto;

/**
 *
 * @author Maicon
 */
@Entity
public class Material{
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "COD_MATERIAL")
    private Integer codigo;
    
    @Column(name = "DESCRICAO")
    private String descricao;
    
    @Column(name = "PRECO")
    private Double preco;
    
    @ManyToMany(mappedBy = "materiais")
    private List<Produto> produtos;
    
    @Column(name = "ATIVO")
    private Boolean ativo;
    
    public Material(Integer codigo, String descricao, Double preco) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.preco = preco;
    }

    public Material() {
        super();
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public Boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }
    
}
