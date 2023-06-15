package com.proyecto.hotel.DAO;

import com.proyecto.hotel.ENTITIES.Sede;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface SedeDAO extends JpaRepository<Sede, Long>{
    
    @Query("select s from Sede s where s.pais.cod_pais=?1")
	public List<Sede> listCiuByPais(Long codPais);
    
}
