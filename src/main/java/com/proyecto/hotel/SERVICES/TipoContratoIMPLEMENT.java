
package com.proyecto.hotel.SERVICES;

import com.proyecto.hotel.DAO.TipoContratoDAO;
import com.proyecto.hotel.ENTITIES.TipoContrato;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TipoContratoIMPLEMENT implements TipoContratoSERVICE{
    
    @Autowired
    private TipoContratoDAO tipoContratoDAO;
    

    @Override
    @Transactional(readOnly = true)
    public List<TipoContrato> listarTipoContrato() {
        return (List<TipoContrato>)tipoContratoDAO.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public TipoContrato buscarTipoContrato(TipoContrato tipoContrato) {
        return tipoContratoDAO.findById(tipoContrato.getCod_con()).orElse(null);
    }
    
}
