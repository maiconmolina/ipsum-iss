package entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Produto extends Entidade implements Serializable {

    @Column(name = "DESCRICAO")
    private String descricao;

    @Column(name = "PRECO")
    private Double preco;

    /*@ManyToMany //Mapeamento bidirecional
     @JoinTable(name="MATERIAIS_DO_PRODUTO", joinColumns={@JoinColumn(name="COD_PRODUTO")}, inverseJoinColumns={@JoinColumn(name="COD_MATERIAL")})
     private List<Material> materiais; 
    
     @ManyToMany(mappedBy = "produtos")
     private List<Lote> lotes;*/
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "produto")
//    private Collection<ProdutoDoLote> produtoDoLoteCollection;
//    
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "produto")
//    private Collection<MaterialDoProduto> materialDoProdutoCollection;
}
