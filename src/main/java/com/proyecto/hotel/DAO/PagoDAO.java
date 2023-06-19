package com.proyecto.hotel.DAO;

import com.proyecto.hotel.ENTITIES.Pago;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PagoDAO extends JpaRepository<Pago, Long>{
    
}
