package com.proyecto.hotel.SERVICES;

import com.proyecto.hotel.ENTITIES.Estado;
import java.util.List;

public interface EstadoSERVICE {
    
    public List<Estado> listarEstado();
    
    public Estado buscarEstado(Estado estado);
    
}
