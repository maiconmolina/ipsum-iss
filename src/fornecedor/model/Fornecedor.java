package fornecedor.model;

import Util.ReturnValidate;
import Util.UfEnum;
import Util.Util;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import usuario.model.Usuario;

@Entity
public class Fornecedor extends Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer codigo;
    
    @Column (length = 14, name = "CNPJ")
    private String cnpj;
    
    @Column (length = 200, name = "RAZAO")
    private String razao;
    
    @Column (length = 200, name = "FANTASIA")
    private String fantasia;
    
    @Column (length = 20, name = "TELEFONE")
    private String telefone;
    
    @Column (length = 200, name = "ENDERECO")
    private String endereço;
    
    @Column (length = 10, name = "NUMERO")
    private Integer numero;
    
    @Column (name = "UF")
    private UfEnum uf;
    
    @Column (length = 200, name = "CIDADE")
    private String cidade;
    
    @Column (length = 8, name = "CEP")
    private String cep;
    
    @Column (length = 200, name= "EMAIL")
    private String email;    
    
    @Column (name = "ATIVO")
    private Boolean ativo;
    
    public Fornecedor() {
        super();
        this.codigo = null;
        this.cnpj = new String();
        this.fantasia = new String();
        this.razao = new String();
        this.telefone = new String();
        this.numero = null;
        this.endereço = new String();
        this.uf = null;
        this.cidade = new String();
        this.cep = new String();
        this.email = new String();
        this.ativo = true;
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
        this.cnpj = cnpj.replace(".", "").replace("-", "").replace("/", "");
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

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }
    
    public void setNumero(String numero){
        if(Util.isNumeric(numero)){
            this.numero = Integer.parseInt(numero);
        }else{
            this.numero = null;
        }
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone.replace("(", "").replace(")", "").replace("-", "");
    }

    public String getEndereço() {
        return endereço;
    }

    public void setEndereço(String endereço) {
        this.endereço = endereço;
    }

    public UfEnum getUf() {
        return uf;
    }

    public void setUf(UfEnum uf) {
        this.uf = uf;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getCep() {
        return cep.replace("-", "");
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

    public Boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }
    @Override
    public ReturnValidate isValid() {
        String retorno = "";
        if (!this.isValidCnpj()) {
            retorno += "CNPJ cadastrado já está em uso\n";
        }
        ReturnValidate validacaoUsuario = super.isValid();
        if (!validacaoUsuario.isValid()) {
            retorno += validacaoUsuario.getMessage();
        }

        return new ReturnValidate(retorno);
    }
    
    private boolean isValidCnpj() {
        FornecedorDAOImpl forn = new FornecedorDAOImpl();
        List<Fornecedor> fornecedores = forn.getAll(Fornecedor.class);
        if (this.getCodigo() == null){
            for (Fornecedor f: fornecedores){
                if (f.getCnpj().equals(this.getCnpj())) {
                    return false;
                }     
            }
        } else{
            for (Fornecedor f: fornecedores){
                if (f.getCnpj().equals(this.getCnpj()) && !this.getCodigo().equals(f.getCodigo())) {
                    return false;
                }
            }
        }
        return true;
    }
             
    public ReturnValidate save() {
        ReturnValidate validacao = this.isValid();
        if (validacao.isValid()) {
            FornecedorDAOImpl forn = new FornecedorDAOImpl();
            forn.save(this);
        }
        return validacao;
    }
}
