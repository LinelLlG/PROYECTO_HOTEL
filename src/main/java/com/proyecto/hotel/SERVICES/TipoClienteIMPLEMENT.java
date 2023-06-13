package com.proyecto.hotel.SERVICES;

import com.proyecto.hotel.DAO.TipoClienteDAO;
import com.proyecto.hotel.ENTITIES.TipoCliente;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TipoClienteIMPLEMENT implements TipoClienteSERVICE{
    
    @Autowired
    private TipoClienteDAO tipoClienteDao;

    @Override
    @Transactional(readOnly = true)
    public List<TipoCliente> listarTipoCliente() {
        return (List<TipoCliente>)tipoClienteDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public TipoCliente buscarTipoCliente(TipoCliente tipoCliente) {
        return tipoClienteDao.findById(tipoCliente.getCod_tip_cli()).orElse(null);
    }
    
}
