/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ipsum.controller;

import produto.model.Produto;
import produto.model.ProdutoDAO;

/**
 *
 * @author Maicon
 */
public class ProdutoController {
    private ProdutoDAO dao;
    
    public ProdutoController(){
        this.dao = new ProdutoDAO();
    }
    
    public void inserir(Produto produto){
        
    }
}
