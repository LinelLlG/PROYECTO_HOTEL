package com.proyecto.hotel.DAO;

import com.proyecto.hotel.ENTITIES.Pabellon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PabellonDAO extends JpaRepository<Pabellon, Long>{
    
}