package com.proyecto.hotel.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.proyecto.hotel.ENTITIES.Boleta;

public interface BoletaRepository extends JpaRepository<Boleta,Integer >{

	
	//@Query("select c from Contratista c where c.proyecto.cod_proyecto=?1")
	//public List<Contratista> lisAllByProyecto(int codPro);
	
	@Query("select b from Boleta b where b.cod_bol =?1")
	public List<Boleta> listAllByCod(int cod);
	
	
}
