package entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Material_ extends Entidade implements Serializable {

    @Column(name = "DESCRICAO")
    private String descricao;

    @Column(name = "PRECO")
    private Double preco;

    @Column(name = "QTDE")
    private Integer qtde;

//    @ManyToMany(mappedBy = "materiais")
//    private List<Produto> produtos;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "material")
//    private Collection<MaterialDoProduto> materialDoProdutoCollection;
}
