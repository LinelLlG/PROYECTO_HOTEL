
package com.proyecto.hotel.SERVICES;

import com.proyecto.hotel.ENTITIES.TipoContrato;
import java.util.List;

public interface TipoContratoSERVICE {
    
    public List<TipoContrato> listarTipoContrato();
    public TipoContrato buscarTipoContrato (TipoContrato tipoContrato);
}
