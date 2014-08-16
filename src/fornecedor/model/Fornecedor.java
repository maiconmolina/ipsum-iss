package fornecedor.model;

import usuario.model.Usuario;

public class Fornecedor extends Usuario {

    private Integer codigo;
    private String cnpj;
    private String nome;
    private String telefone;
    private String endereço;
    private String uf;
    private String cidade;
    private String cep;
    private String email;    
    
    public Fornecedor() {
        super();
        this.codigo = null;
        this.cnpj = new String();
        this.nome = new String();
        this.telefone = new String();
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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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
