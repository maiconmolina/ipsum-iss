package funcionario.model;

import Util.RemovableLogically;
import Util.ReturnValidate;
import Util.Util;
import funcao.model.Funcao;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Collection;
import java.util.List;
import javax.persistence.*;
import lote.model.Lote;
import usuario.model.Usuario;

@Entity
@NamedQueries({
    @NamedQuery(name = "Funcionario.findAll", query = "SELECT f FROM Funcionario f"),
    @NamedQuery(name = "Funcionario.findByCodfunc", query = "SELECT f FROM Funcionario f WHERE f.codfunc = :codfunc")})
public class Funcionario extends Usuario implements Serializable, RemovableLogically {

    @Column(length = 255, name = "NOME", nullable = false)
    private String nome;

    @Column(name = "SALARIO", nullable = false)
    private Double salario;

    @Column(name = "DATA_NASCIMENTO", nullable = false)
    @Temporal(TemporalType.DATE)
    private Calendar dataNascimento;

    @Column(length = 11, name = "CPF", nullable = false)
    private String cpf;

    @Column(length = 25, name = "RG", nullable = false)
    private String rg;

    @Column(name = "TEMPORARIO", nullable = false)
    private boolean temporario;

    @Column(length = 10, name = "TELEFONE", nullable = false)
    private String telefone;

    @Column(name = "NIVEL_HABILIDADE", nullable = false)
    private NivelHabilidade nivel;

    @Column(length = 255, name = "ENDERECO", nullable = false)
    private String endereco;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "Funcao")
    private Funcao funcao;

    @Column(name = "ATIVO", nullable = false)
    private Boolean ativo;

    @ManyToMany(mappedBy = "Lote", fetch = FetchType.EAGER)
    @JoinColumn(name = "Lote")
    private Collection<Lote> loteCollection;

    public Funcionario() {
        super();
        this.nome = new String();
        this.dataNascimento = Calendar.getInstance();
        this.cpf = new String();
        this.rg = new String();
        this.temporario = false;
        this.telefone = new String();
        this.endereco = new String();
        this.funcao = new Funcao();
        this.nivel = NivelHabilidade.INICIANTE;
        this.ativo = true;
        this.salario = 0.0;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public void setSalario(String salario) {
        try {
            salario = salario.replace(",", ".");
            this.salario = Double.parseDouble(salario);
        } catch (NumberFormatException ex) {
            this.salario = 0.0;
        }
    }

    public Calendar getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Calendar dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = Util.StringToCalendar(dataNascimento);
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        if (Util.ValidateCpf(cpf)) {
            this.cpf = cpf.replace(".", "").replace("-", "");
        }
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg.replace(".", "").replace("-", "").trim();
    }

    public boolean isTemporario() {
        return temporario;
    }

    public void setTemporario(boolean temporario) {
        this.temporario = temporario;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone.replace("(", "").replace(")", "").replace("-", "").trim();
    }

    public NivelHabilidade getNivel() {
        return nivel;
    }

    public void setNivel(NivelHabilidade nivel) {
        this.nivel = nivel;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Funcao getFuncao() {
        return funcao;
    }

    public void setFuncao(Funcao funcao) {
        this.funcao = funcao;
    }

    @Override
    public Boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    @Override
    public ReturnValidate isValid() {
        String retorno = "";
        if (!this.isValidCpf()) {
            retorno += "CPF cadastrado já está em uso\n";
        }
        ReturnValidate validacaoUsuario = super.isValid();
        if (!validacaoUsuario.isValid()) {
            retorno += validacaoUsuario.getMessage();
        }

        return new ReturnValidate(retorno);
    }

    private boolean isValidCpf() {
        FuncionarioDaoImpl func = new FuncionarioDaoImpl();
        List<Funcionario> funcionarios = func.getAll(Funcionario.class);
        if (this.getCodigo() == null) {
            for (Funcionario f : funcionarios) {
                if (f.getCpf().equals(this.getCpf())) {
                    return false;
                }
            }
        } else {
            for (Funcionario f : funcionarios) {
                if (f.getCpf().equals(this.getCpf()) && !this.getCodigo().equals(f.getCodigo())) {
                    return false;
                }
            }
        }
        return true;
    }

    public ReturnValidate save() {
        ReturnValidate validacao = this.isValid();
        if (validacao.isValid()) {
            FuncionarioDaoImpl func = new FuncionarioDaoImpl();
            func.save(this);
        }
        return validacao;
    }

    @Override
    public ReturnValidate inativar() {
        this.ativo = false;
        return new ReturnValidate("");
    }

    @Override
    public ReturnValidate reativar() {
        this.ativo = true;
        return new ReturnValidate("");
    }

    /*public static List<Funcionario> getAll() {
     FuncionarioDaoImpl func = new FuncionarioDaoImpl();
     return func.getAll(Funcionario.class);
     }

     public static List<Funcionario> getAllActive() {
     FuncionarioDaoImpl func = new FuncionarioDaoImpl();
     return func.getAllActive();
     }*/
    @Override
    public String toString() {
        return this.nome;
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

    public String getCpfMasked() {
        String retorno = "";
        String c = this.cpf;
        retorno += c.substring(0, 3);
        retorno += '.';
        retorno += c.substring(3, 6);
        retorno += '.';
        retorno += c.substring(6, 9);
        retorno += '-';
        retorno += c.substring(9);
        return retorno;
    }

    public static Funcionario getByCodigo(Integer codigo) {
        FuncionarioDaoImpl func = new FuncionarioDaoImpl();
        return func.getById(Funcionario.class, codigo);
    }

    /*public void print() {
     //Função de testes
     System.out.println(
     "\n\nCodigo: " + super.getCodigo()
     + "\nLogin: " + super.getLogin()
     + "\nSenha: " + super.getSenha()
     + "\nNome: " + this.nome
     + "\nSalário: " + this.salario
     + "\nDataNasc: " + Util.CalendarToString(dataNascimento)
     + "\nCpf: " + this.cpf
     + "\nRg: " + this.rg
     + "\nTemporario: " + this.temporario
     + "\nTelefone: " + this.telefone
     + "\nEndereço: " + this.endereco
     + "\nFunção: " + this.funcao
     + "\nNível: " + this.nivel
     + "\nAtivo: " + this.ativo
     + "\n\n"
     );
     }*/
}
