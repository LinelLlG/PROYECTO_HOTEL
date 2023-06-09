package com.proyecto.hotel.ENTITIES;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "tb_pais")
public class Pais implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cod_pais;

    private String nom_pais;

    @OneToMany(mappedBy = "pais")
    private List<Proveedor> listaProveedor;

    @OneToMany(mappedBy = "pais")
    private List<Sede> listaSede;
    
}