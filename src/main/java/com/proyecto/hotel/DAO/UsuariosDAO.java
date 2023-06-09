package com.proyecto.hotel.DAO;

import com.proyecto.hotel.ENTITIES.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuariosDAO extends JpaRepository<Usuarios, Long>{
    Usuarios findByUsername(String username);
}