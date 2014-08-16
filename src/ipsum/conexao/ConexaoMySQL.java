/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ipsum.conexao;

import java.sql.Connection;

/**
 *
 * @author Maicon
 */
public class ConexaoMySQL {
    private Connection con = null;
    public Connection getConexao(){
        return this.con;
    }
}
