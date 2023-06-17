/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.proyecto.hotel.DAO;

import com.proyecto.hotel.ENTITIES.TipoStock;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Nefi Alvarado
 */
public interface TipoStockDAO extends JpaRepository<TipoStock, Long> {
    
}
