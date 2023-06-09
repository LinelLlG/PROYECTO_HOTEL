package com.proyecto.hotel.ENTITIES;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "tb_usuarios")
public class Usuarios implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long    cod_usuarios;
    
    private String  username;
    
    private String  clave;
    
    @OneToMany
    @JoinColumn(name = "cod_usuarios")
    private List<Roles> roles;
    
    public Usuarios() {
        
    }

    public Usuarios(Long codUsu) {
        this.cod_usuarios = codUsu;
    }

    
}