package produto.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
import lote.model.Lote;
import material.model.Material;


@Entity
public class Produto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "COD_PRODUTO")
    private Integer codigo;
    
    @Column(name = "DESCRICAO")
    private String descricao;
    
    @Column(name = "PRECO")
    private Double preco;
    
    @ManyToMany //Mapeamento bidirecional
    @JoinTable(name="MATERIAIS_DO_PRODUTO", joinColumns={@JoinColumn(name="COD_PRODUTO")}, inverseJoinColumns={@JoinColumn(name="COD_MATERIAL")})
    private List<Material> materiais; 
    
    @ManyToMany(mappedBy = "produtos")
    private List<Lote> lotes;
    
    @Column(name = "ATIVO")
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

    public List<Material> getMateriais() {
        return materiais;
    }

    public void setMateriais(List<Material> materiais) {
        this.materiais = materiais;
    }

    public Boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public List<Lote> getLotes() {
        return lotes;
    }

    public void setLotes(List<Lote> lotes) {
        this.lotes = lotes;
    }
            
}
