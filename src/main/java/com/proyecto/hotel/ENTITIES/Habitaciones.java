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
@Table(name = "tb_habitaciones")
public class Habitaciones implements Serializable{
    
     private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cod_hab;

    private String nom_hab;

    private String num_hab;

    @ManyToOne
    @JoinColumn(name="cod_pab")
    private Pabellon pabellon;

    
    @ManyToOne
    @JoinColumn(name="cod_tip_hab")
    private TipoHabitacion tipoHabitacion;

    @ManyToOne
    @JoinColumn(name="cod_pis")
    private Pisos pisos;


    public Habitaciones() {
            super();
    }
    public Habitaciones(Long cod_hab) {
            super();
            this.cod_hab = cod_hab;
    }

    @ManyToOne
    @JoinColumn(name="cod_disp")
    private Disponibilidad disponibilidad;

    @JsonIgnore
    @OneToMany(mappedBy = "habitaciones")
    private List<Reserva> listaReserva;

}