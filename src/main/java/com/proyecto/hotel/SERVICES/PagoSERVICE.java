package com.proyecto.hotel.SERVICES;

import com.proyecto.hotel.ENTITIES.Pago;
import java.util.List;

public interface PagoSERVICE {
    
    public List<Pago> listarPago();
    
    public Pago buscarPago(Pago pago);
    
}
