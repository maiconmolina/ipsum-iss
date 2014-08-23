package usuario.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

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

}
