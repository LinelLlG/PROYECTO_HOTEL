package com.proyecto.hotel.ENTITIES;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import java.io.Serializable;
import java.util.List;
import javax.persistence.OneToMany;

@Data
@Entity
@Table(name = "tb_cargo")
public class Cargo implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cod_crg;
    
    private String nom_crg;
    
    @OneToMany(mappedBy = "cargo")
    private List<Empleado> listaEmpleado;
    
}