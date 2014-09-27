/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lote.controller;

import java.util.List;
import lote.model.Lote;
import lote.model.LoteDAOImpl;

/**
 *
 * @author Maicon
 */
public class LoteController {
    public static List<Lote> getAll(){
        LoteDAOImpl lotedao = new LoteDAOImpl();
        return lotedao.getAll(Lote.class);
    }
    
}
