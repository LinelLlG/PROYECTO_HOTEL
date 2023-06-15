/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.hotel.DAO;

import com.proyecto.hotel.ENTITIES.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Jan
 */
public interface EmpleadoDAO extends JpaRepository<Empleado, Long>{
    
}
