package com.proyecto.hotel.SERVICES;

import com.proyecto.hotel.ENTITIES.Pabellon;
import java.util.List;

public interface PabellonSERVICE {
    
    public List<Pabellon> listarPabellon();
    
    public Pabellon buscarPabellon(Pabellon pabellon);
    
}
