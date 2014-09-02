package fornecedor.model;

import Util.RemovableLogically;
import Util.ReturnValidate;
import Util.UfEnum;
import Util.Util;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import usuario.model.Usuario;

@Entity
public class Fornecedor extends Usuario implements Serializable, RemovableLogically {
    
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
    private Integer numero;
    
    @Column (name = "UF", nullable = false)
    private UfEnum uf;
    
    @Column (length = 200, name = "CIDADE", nullable = false)
    private String cidade;
    
    @Column (length = 8, name = "CEP", nullable = false)
    private String cep;
    
    @Column (length = 200, name= "EMAIL", nullable = true)
    private String email;    
    
    @Column (name = "ATIVO", nullable = false)
    private Boolean ativo;
    
    public Fornecedor() {
        super();
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
        return this.cep;
    }

    public void setCep(String cep) {
        this.cep = cep.replace("-", "");
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

    @Override
    public ReturnValidate inativar() {
        this.ativo = false;
        return this.save();
    }

    @Override
    public ReturnValidate reativar() {
        this.ativo = true;
        return this.save();
    }
    
    public static List<Fornecedor> getAll() {
        FornecedorDAOImpl forn = new FornecedorDAOImpl();
        return forn.getAll(Fornecedor.class);
    }

    public static List<Fornecedor> getAllActive() {
        FornecedorDAOImpl forn = new FornecedorDAOImpl();
        return forn.getAllActive();
    }
    
    @Override
    public String toString() {
        return this.razao;
    }
    
    public String getTelefoneMasked() {
        String retorno = "";
        String fone = this.telefone;
        retorno += '(';
        retorno += fone.substring(0, 2);
        retorno += ')';
        retorno += fone.substring(2, 6);
        retorno += '-';
        retorno += fone.substring(6);

        return retorno;
    }
    
     public String getCNPJMasked() {
        String retorno = "";
        String c = this.cnpj;
        retorno += c.substring(0, 2);
        retorno += '.';
        retorno += c.substring(2, 5);
        retorno += '.';
        retorno += c.substring(5, 8);
        retorno += '/';
        retorno += c.substring(8, 12);
        retorno += '-';
        retorno += c.substring(12);
        return retorno;
    }
    
    
    public static Fornecedor getByCodigo(Integer codigo) {
        FornecedorDAOImpl forn = new FornecedorDAOImpl();
        return forn.getById(Fornecedor.class, codigo);
    }
}
