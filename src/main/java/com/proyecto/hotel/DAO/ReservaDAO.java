package com.proyecto.hotel.DAO;

import com.proyecto.hotel.ENTITIES.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservaDAO extends JpaRepository<Reserva, Long>{
    
}
