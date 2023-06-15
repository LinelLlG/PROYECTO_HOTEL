package com.proyecto.hotel.SERVICES;

import com.proyecto.hotel.ENTITIES.Sede;
import java.util.List;

public interface SedeService {
    
    public List<Sede> listarSede();
    
    public Sede buscarSede(Sede sede);
    
    public List<Sede> listSedeByPais(Long codPais);
    
}
