package com.proyecto.hotel.SERVICES;

import com.proyecto.hotel.ENTITIES.TipoHabitacion;
import java.util.List;

public interface TipoHabitacionSERVICE {
    
    public List<TipoHabitacion> listarTipoHabitacion();
    
    public TipoHabitacion buscarTipoHabitacion(TipoHabitacion tipoHabitacion);
    
}
