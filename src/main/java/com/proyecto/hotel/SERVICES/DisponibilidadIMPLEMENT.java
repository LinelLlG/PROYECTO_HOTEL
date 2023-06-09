package com.proyecto.hotel.SERVICES;

import com.proyecto.hotel.DAO.DisponibilidadDAO;
import com.proyecto.hotel.ENTITIES.Disponibilidad;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DisponibilidadIMPLEMENT implements DisponibilidadSERVICE{
    
    @Autowired
    private DisponibilidadDAO disponibilidadDao;
    
    @Override
    @Transactional(readOnly = true)
    public List<Disponibilidad> listarDisponibilidad() {
        return (List<Disponibilidad>)disponibilidadDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Disponibilidad buscarDisponibilidad(Disponibilidad disponibilidad) {
        return disponibilidadDao.findById(disponibilidad.getCod_disp()).orElse(null);
    }
    
}
