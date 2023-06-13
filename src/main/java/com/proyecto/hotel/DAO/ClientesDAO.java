package com.proyecto.hotel.DAO;

import com.proyecto.hotel.ENTITIES.Clientes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientesDAO extends JpaRepository<Clientes, Long>{
    
}
