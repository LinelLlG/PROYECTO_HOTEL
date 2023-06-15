/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.proyecto.hotel.DAO;

import com.proyecto.hotel.ENTITIES.Servicio;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ServicioDAO extends JpaRepository<Servicio, Long>{
    
}
