package usuario.model;

public abstract class Usuario {

    private String login;
    private String senha;

    public Usuario() {
        this.login = new String();
        this.senha = new String();
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

}
