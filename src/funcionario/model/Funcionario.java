package funcionario.model;

import Util.Util;
import java.util.GregorianCalendar;
import usuario.model.Usuario;

public class Funcionario extends Usuario {

    private Integer codigo;
    private String nome;
    private double salario;
    private GregorianCalendar dataNascimento;
    private String cpf;
    private String rg;
    private boolean temporario;
    private String telefone;
    private NivelHabilidade nivel;
    private String endereco;
    private Funcoes funcao;

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
        this.funcao = Funcoes.Costureiro;
        this.nivel = NivelHabilidade.Iniciante;
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
        this.cpf = cpf.replace(".", "").replace("-", "");;
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

}
