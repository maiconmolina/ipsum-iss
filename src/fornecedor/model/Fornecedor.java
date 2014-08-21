package fornecedor.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import usuario.model.Usuario;

@Entity
public class Fornecedor extends Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer codigo;
    
    @Column (length = 14, name = "CNPJ", nullable = false)
    private String cnpj;
    
    @Column (length = 200, name = "RAZAO", nullable = false)
    private String razao;
    
    @Column (length = 200, name = "FANTASIA", nullable = true)
    private String fantasia;
    
    @Column (length = 20, name = "TELEFONE", nullable = false)
    private String telefone;
    
    @Column (length = 200, name = "ENDERECO", nullable = false)
    private String endereço;
    
    @Column (length = 10, name = "NUMERO", nullable = false)
    private int numero;
    
    @Column (length = 50, name = "UF", nullable = false)
    private String uf;
    
    @Column (length = 200, name = "CIDADE", nullable = false)
    private String cidade;
    
    @Column (length = 8, name = "CEP", nullable = false)
    private String cep;
    
    @Column (length = 200, name= "EMAIL", nullable = true)
    private String email;    
    
    public Fornecedor() {
        super();
        this.codigo = null;
        this.cnpj = new String();
        this.fantasia = new String();
        this.razao = new String();
        this.telefone = new String();
        this.numero = 0;
        this.endereço = new String();
        this.uf = new String();
        this.cidade = new String();
        this.cep = new String();
        this.email = new String();
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getRazao() {
        return razao;
    }

    public void setRazao(String razao) {
        this.razao = razao;
    }

    public String getFantasia() {
        return fantasia;
    }

    public void setFantasia(String fantasia) {
        this.fantasia = fantasia;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereço() {
        return endereço;
    }

    public void setEndereço(String endereço) {
        this.endereço = endereço;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    
}
