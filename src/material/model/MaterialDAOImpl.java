/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package material.model;

import persistencia.DAOImpl;

/**
 *
 * @author Maicon
 */
public class MaterialDAOImpl extends DAOImpl<Material, Integer> implements MaterialDAO{

    
    public Material getById(Integer pk) {
        return super.getById(Material.class, pk);
    }
    
}