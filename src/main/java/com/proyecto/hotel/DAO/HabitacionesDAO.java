package com.proyecto.hotel.DAO;

import com.proyecto.hotel.ENTITIES.Habitaciones;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HabitacionesDAO extends JpaRepository<Habitaciones, Long>{
    
}