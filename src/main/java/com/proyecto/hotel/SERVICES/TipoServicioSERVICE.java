/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.proyecto.hotel.SERVICES;

import com.proyecto.hotel.ENTITIES.TipoServicio;
import java.util.List;


public interface TipoServicioSERVICE {
    
    public List<TipoServicio> listaTipoServicio();
    
    public TipoServicio buscarTipoServicio(TipoServicio tipoServicio );
}
