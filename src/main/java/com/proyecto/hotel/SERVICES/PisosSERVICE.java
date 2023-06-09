package com.proyecto.hotel.SERVICES;

import com.proyecto.hotel.ENTITIES.Pisos;
import java.util.List;

public interface PisosSERVICE {
    
    public List<Pisos> listarPisos();
    
    public Pisos buscarPisos(Pisos pisos);
    
}
