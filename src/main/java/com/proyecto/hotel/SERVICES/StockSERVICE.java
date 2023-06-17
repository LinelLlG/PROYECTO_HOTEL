/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.proyecto.hotel.SERVICES;

import com.proyecto.hotel.ENTITIES.Stock;
import java.util.List;
/**
 *
 * @author Nefi Alvarado
 */
public interface StockSERVICE {
     public List<Stock> listarStock();
    
    public void guardarStock(Stock stock);
    
    public void eliminarStock(Stock stock);
    
    public Stock buscarStock(Stock stock);
}
