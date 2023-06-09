package com.proyecto.hotel.SERVICES;

import com.proyecto.hotel.DAO.TipoHabitacionDAO;
import com.proyecto.hotel.ENTITIES.TipoHabitacion;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TipoHabitacionIMPLEMENT implements TipoHabitacionSERVICE{
    
    @Autowired
    private TipoHabitacionDAO tipoHabitacionDao;

    @Override
    @Transactional(readOnly = true)
    public List<TipoHabitacion> listarTipoHabitacion() {
        return (List<TipoHabitacion>)tipoHabitacionDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public TipoHabitacion buscarTipoHabitacion(TipoHabitacion tipoHabitacion) {
        return tipoHabitacionDao.findById(tipoHabitacion.getCod_tip_hab()).orElse(null);
    }
    
}
