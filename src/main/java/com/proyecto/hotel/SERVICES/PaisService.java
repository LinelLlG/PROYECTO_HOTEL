package com.proyecto.hotel.SERVICES;

import com.proyecto.hotel.ENTITIES.Pais;
import java.util.List;

public interface PaisService {
    
    public List<Pais> listarPais();
    
    public Pais buscarPais(Pais pais);
    
}
