package com.proyecto.hotel.DAO;

import com.proyecto.hotel.ENTITIES.Habitaciones;
import org.springframework.data.repository.CrudRepository;

public interface HabitacionesDAO extends CrudRepository<Habitaciones, Long>{
    
}