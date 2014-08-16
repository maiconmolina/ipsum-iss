/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lote.model;


import java.util.List;
import produto.model.Produto;
import javax.persistence.*;


/**
 *
 * @author Maicon
 */

@Entity
public class Lote {
    @Id
    private Integer codigo;
    private List<Produto> produtos;
    
    
}
