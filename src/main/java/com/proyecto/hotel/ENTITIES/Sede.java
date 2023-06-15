package com.proyecto.hotel.ENTITIES;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "tb_sede")
public class Sede  implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cod_sed;
    
    private String nom_sed;

    @JsonIgnore
    @OneToMany(mappedBy = "sede")
    private List<Proveedor> listaProveedor;
    
    @ManyToOne
    @JoinColumn(name="cod_pais")
    private Pais pais;


    
}