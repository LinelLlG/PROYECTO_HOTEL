package com.proyecto.hotel.SERVICES;

import com.proyecto.hotel.ENTITIES.Disponibilidad;
import java.util.List;

public interface DisponibilidadSERVICE {
    
    public List<Disponibilidad> listarDisponibilidad();
    
    public Disponibilidad buscarDisponibilidad(Disponibilidad disponibilidad);
    
}
