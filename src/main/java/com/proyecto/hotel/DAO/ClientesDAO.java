package com.proyecto.hotel.DAO;

import com.proyecto.hotel.ENTITIES.Clientes;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ClientesDAO extends JpaRepository<Clientes, Long>{
    
    @Query("select c from Clientes c where c.ape_cli like ?1")
    public List<Clientes> listAllByPaterno(String ape);
    
}
