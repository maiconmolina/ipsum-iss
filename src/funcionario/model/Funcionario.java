package funcionario.model;

import Util.Util;
import java.util.GregorianCalendar;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import usuario.model.Usuario;

@Entity
public class Funcionario extends Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer codigo;

    @Column(length = 255, name = "NOME", nullable = false)
    private String nome;

    @Column(name = "SALARIO", nullable = false)
    private double salario;

    @Column(name = "DATA_NASCIMENTO", nullable = false)
    private GregorianCalendar dataNascimento;

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

    @Column(name = "FUNCAO", nullable = false)
    private Funcoes funcao;

    @Column(name = "ATIVO", nullable = false)
    private Boolean ativo;

    public Funcionario() {
        super();
        this.codigo = null;
        this.nome = new String();
        this.dataNascimento = new GregorianCalendar();
        this.cpf = new String();
        this.rg = new String();
        this.temporario = false;
        this.telefone = new String();
        this.endereco = new String();
        this.funcao = Funcoes.COSTUREIRO;
        this.nivel = NivelHabilidade.INICIANTE;
        this.ativo = true;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public void setSalario(String salario) {
        try {
            salario = salario.replace(",", ".");
            this.salario = Double.parseDouble(salario);
        } catch (NumberFormatException ex) {
            this.salario = 0;
        }
    }

    public GregorianCalendar getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(GregorianCalendar dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = Util.StringToGregorian(dataNascimento);
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf.replace(".", "").replace("-", "");
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

    public Funcoes getFuncao() {
        return funcao;
    }

    public void setFuncao(Funcoes funcao) {
        this.funcao = funcao;
    }

    public Boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

}
