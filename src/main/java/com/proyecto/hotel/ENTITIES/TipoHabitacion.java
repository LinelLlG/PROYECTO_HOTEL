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
@Table(name = "tb_tipohabitacion")  //TODO DEBE SER CON MINUSCULA
public class TipoHabitacion implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cod_tip_hab;
    
    private String nom_tip_hab;

    @OneToMany(mappedBy = "tipoHabitacion")
    private List<Habitaciones> listaHabitacion;
    
}