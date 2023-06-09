package com.proyecto.hotel.SERVICES;

import com.proyecto.hotel.DAO.HabitacionesDAO;
import com.proyecto.hotel.ENTITIES.Habitaciones;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class HabitacionesIMPLEMENT implements HabitacionesSERVICE{
    
    @Autowired
    private HabitacionesDAO habitacionesDao;
    
    @Override
    @Transactional(readOnly = true)
    public List<Habitaciones> listarHabitaciones() {
        return habitacionesDao.findAll();
    }

    @Override
    @Transactional
    public void guardarHabitaciones(Habitaciones habitaciones) {
        habitacionesDao.save(habitaciones);
    }

    @Override
    @Transactional
    public void eliminarHabitaciones(Habitaciones habitaciones) {
        habitacionesDao.delete(habitaciones);
    }

    @Override
    @Transactional(readOnly = true)
    public Habitaciones buscarHabitaciones(Habitaciones habitaciones) {
        return habitacionesDao.findById(habitaciones.getCod_hab()).orElse(null);
    }
    
}
