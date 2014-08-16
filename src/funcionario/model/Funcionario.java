/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package funcionario.model;


/**
 *
 * @author maiconmolina
 */
public class Funcionario  {
    private int codigo;
    private String login;
    private String senha;

    public Funcionario() {
        super();
    }

    public String getLogin() {
        return this.login;
    }
    
    public void setLogin(String login) {
        this.login = login;
    }
    
    public String getSenha() {
        return this.senha;
    }
    
    public void setSenha(String senha) {
        this.senha = senha;
    }
            
    
    
    
}
