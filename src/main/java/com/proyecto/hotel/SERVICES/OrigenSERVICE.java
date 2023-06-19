package com.proyecto.hotel.SERVICES;

import com.proyecto.hotel.ENTITIES.Origen;
import java.util.List;

public interface OrigenSERVICE {
    
    public List<Origen> listarOrigen();
    
    public Origen buscarOrigen(Origen origen);
    
}
