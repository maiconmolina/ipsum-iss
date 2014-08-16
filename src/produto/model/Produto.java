/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package produto.model;

import java.util.ArrayList;
import java.util.List;
import material.model.Material;
import javax.persistence.*;


/**
 *
 * @author Maicon
 */
@Entity
public class Produto {
    @Id
    private Integer codigo;
    private String descricao;
    private Double preco;
    private List<Material> material; 
    private Boolean ativo;

    public Produto(Integer codigo) {
        this.codigo = codigo;
    }

    public Produto() {
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

    public List<Material> getMaterial() {
        return material;
    }

    public void setMaterial(List<Material> material) {
        this.material = material;
    }

    public Boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }
    
    
    
}
