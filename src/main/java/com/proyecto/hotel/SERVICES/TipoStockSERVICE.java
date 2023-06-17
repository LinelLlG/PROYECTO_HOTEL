/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.proyecto.hotel.SERVICES;

import com.proyecto.hotel.ENTITIES.TipoStock;
import java.util.List;

/**
 *
 * @author Nefi Alvarado
 */
public interface TipoStockSERVICE {
    
    public List<TipoStock> listaTipoStock();
    
    public TipoStock buscarTipoStock (TipoStock tipoStock);
   
}
