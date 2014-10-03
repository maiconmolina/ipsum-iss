package entities;

import enums.Uf;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "codigo")
public class Fornecedor extends Usuario implements Serializable {

    @Column(length = 14, name = "CNPJ", nullable = false)
    private String cnpj;

    @Column(length = 200, name = "RAZAO", nullable = false)
    private String razao;

    @Column(length = 200, name = "FANTASIA", nullable = true)
    private String fantasia;

    @Column(length = 20, name = "TELEFONE", nullable = false)
    private String telefone;

    @Column(length = 200, name = "ENDERECO", nullable = false)
    private String endereço;

    @Column(length = 10, name = "NUMERO", nullable = false)
    private Integer numero;

    @Column(name = "UF", nullable = false)
    private Uf uf;

    @Column(length = 200, name = "CIDADE", nullable = false)
    private String cidade;

    @Column(length = 8, name = "CEP", nullable = false)
    private String cep;

    @Column(length = 200, name = "EMAIL", nullable = true)
    private String email;

//    @OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
//    @JoinColumn(name="CUSTOMER_ID")
//    private List lotes;
}
