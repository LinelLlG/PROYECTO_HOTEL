/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.proyecto.hotel.SERVICES;

import com.proyecto.hotel.ENTITIES.Servicio;
import java.util.List;


public interface ServicioSERVICE {
    
    public List<Servicio> listarServicio();
    
    public void guardarServicio(Servicio servicio);
    
    public void eliminarServicio(Servicio servicio);
    
    public Servicio buscarServicio(Servicio servicio);
}
