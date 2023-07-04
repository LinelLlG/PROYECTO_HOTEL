/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.proyecto.hotel.SERVICES;

import com.proyecto.hotel.ENTITIES.Boleta;
import java.util.List;

/**
 *
 * @author Jotace
 */
public interface BoletaService {
    
    
    public void guardarClientes(Boleta boleta);
    
    public List<Boleta> listar(int cod);
    
}
