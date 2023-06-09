package com.proyecto.hotel.SERVICES;

import com.proyecto.hotel.ENTITIES.Habitaciones;
import java.util.List;

public interface HabitacionesSERVICE {
    
    public List<Habitaciones> listarHabitaciones();
    
    public void guardarHabitaciones(Habitaciones habitaciones);
    
    public void eliminarHabitaciones(Habitaciones habitaciones);
    
    public Habitaciones buscarHabitaciones(Habitaciones habitaciones);
    
}