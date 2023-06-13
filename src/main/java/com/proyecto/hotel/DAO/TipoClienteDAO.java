package com.proyecto.hotel.DAO;

import com.proyecto.hotel.ENTITIES.TipoCliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TipoClienteDAO extends JpaRepository<TipoCliente, Long>{
    
}
