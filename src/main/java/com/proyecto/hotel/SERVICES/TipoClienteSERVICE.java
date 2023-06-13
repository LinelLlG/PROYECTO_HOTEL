package com.proyecto.hotel.SERVICES;

import java.util.List;
import com.proyecto.hotel.ENTITIES.TipoCliente;

public interface TipoClienteSERVICE {
    
    public List<TipoCliente> listarTipoCliente();
    
    public TipoCliente buscarTipoCliente(TipoCliente tipoCliente);
    
}
