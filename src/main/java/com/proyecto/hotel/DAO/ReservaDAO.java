package com.proyecto.hotel.DAO;

import com.proyecto.hotel.ENTITIES.Reserva;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ReservaDAO extends JpaRepository<Reserva, Long>{

    @Query("select r from Reserva r where r.origen.cod_orig!=3")
    public List<Reserva> listarReservasActivas ();
    
}
