package usuario.model;

import Util.ReturnValidate;
import Util.Util;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import usuario.controller.UsuarioController;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer codigo;

    @Column(length = 255, name = "LOGIN", nullable = false)
    private String login;

    @Column(length = 255, name = "SENHA", nullable = false)
    private String senha;

    public Usuario() {
        this.codigo = null;
        this.login = new String();
        this.senha = new String();
    }

    public Integer getSuperCodigo() {
        return codigo;
    }

    public void setSuperCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setSenha(char[] senha) {
        String password = "";
        for (int i = 0; i < senha.length; i++) {
            password += senha[i];
            senha[i] = '\0';
        }
        this.senha = password;
    }

    public ReturnValidate isValid() {
        String retorno = "";
        if (Util.isNullOrEmpty(this.getLogin())) {
            retorno += "Campo 'Login' não pode ser vazio\n";
        }
        if (!this.isValidLogin()) {
            retorno += "O Login informado já está cadastrado no sistema\n";
        }
        if (Util.isNullOrEmpty(this.getSenha())) {
            retorno += "Campo 'Senha' não pode ser vazio\n";
        }
        return new ReturnValidate(retorno);
    }

    private boolean isValidLogin() {
        UsuarioDaoImpl usu = new UsuarioDaoImpl();
        List<Usuario> users = usu.getAll(Usuario.class);
        if (this.codigo == null) {
            for (Usuario u : users) {
                if (u.getLogin().equals(this.getLogin())) {
                    return false;
                }
            }
        } else {
            for (Usuario u : users) {
                if (u.getLogin().equals(this.getLogin()) && !this.getSuperCodigo().equals(u.getSuperCodigo())) {
                    return false;
                }
            }
        }
        return true;
    }

}
