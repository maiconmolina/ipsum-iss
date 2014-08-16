/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package produto.model;

import ipsum.conexao.ConexaoMySQL;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author Maicon
 */
public class ProdutoDAO {
    private Connection connection = null;
    private PreparedStatement stm = null;
    
    public void inserir(Produto produto){
        this.connection = new ConexaoMySQL().getConexao();
    }
    
    public void excluir(Produto produto){
        
    }
    
    public void alterar(Produto produto){
        
    }
}
