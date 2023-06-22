package com.proyecto.hotel.SERVICES;

import com.proyecto.hotel.ENTITIES.Reserva;
import java.util.List;

public interface ReservaSERVICE {
    
    public List<Reserva> listarReservasGeneral();
    
    public List<Reserva> listarReservasActivas();
    
    public void guardarReservas(Reserva reserva);
    
    public void eliminarReservas(Reserva reserva);
    
    public Reserva buscarReservas(Reserva reserva);
    
}
