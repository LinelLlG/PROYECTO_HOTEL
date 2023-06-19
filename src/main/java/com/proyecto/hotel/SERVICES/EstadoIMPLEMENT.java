package com.proyecto.hotel.SERVICES;

import com.proyecto.hotel.DAO.EstadoDAO;
import com.proyecto.hotel.ENTITIES.Estado;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EstadoIMPLEMENT implements EstadoSERVICE{
    
    @Autowired
    private EstadoDAO estadoDao;

    @Override
    @Transactional(readOnly = true)
    public List<Estado> listarEstado() {
        return (List<Estado>)estadoDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Estado buscarEstado(Estado estado) {
        return estadoDao.findById(estado.getCod_est()).orElse(null);
    }
    
}
