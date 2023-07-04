package com.proyecto.hotel.DAO;

import com.proyecto.hotel.ENTITIES.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UsuariosDAO extends JpaRepository<Usuarios, Long>{
    Usuarios findByUsername(String username);
    
    @Query("select p from Usuarios p where p.username=?1")
    public Usuarios iniciarSesion(String vUsuario);
}