package com.proyecto.hotel.DAO;

import com.proyecto.hotel.ENTITIES.Habitaciones;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface HabitacionesDAO extends JpaRepository<Habitaciones, Long>{
    
    @Query("select c from Habitaciones c where c.nom_hab like ?1 AND c.disponibilidad.cod_disp=1")
    public List<Habitaciones> listAllByNombre(String nom);
    
}