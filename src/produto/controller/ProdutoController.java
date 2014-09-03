/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package produto.controller;

import produto.model.Produto;
import produto.model.ProdutoDAOImpl;

/**
 *
 * @author Luis
 */
public class ProdutoController {
    
      public static Produto buscaId(String id) {
        ProdutoDAOImpl prod = new ProdutoDAOImpl();
        return prod.getById(Produto.class, Integer.parseInt(id));
    }
      public static Produto buscaId(Integer id) {
        ProdutoDAOImpl prod = new ProdutoDAOImpl();
        return prod.getById(Produto.class, id);
    }
      
      public static void salvar(Produto p){
          ProdutoDAOImpl pdao = new ProdutoDAOImpl();
          pdao.save(p);
      }

}
