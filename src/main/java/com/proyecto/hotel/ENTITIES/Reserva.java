package com.proyecto.hotel.ENTITIES;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "tb_reserva")
public class Reserva implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cod_res;

    @ManyToOne
    @JoinColumn(name = "cod_cli")
    private Clientes clientes;

    @ManyToOne
    @JoinColumn(name="cod_hab")
    private Habitaciones habitaciones;

    private String check_in;
    private String check_out;

    private Double pre_res;
    
    @ManyToOne
    @JoinColumn(name="cod_orig")
    private Origen origen;

    @ManyToOne
    @JoinColumn(name="cod_est")
    private Estado estado;

    @ManyToOne
    @JoinColumn(name="cod_pago")
    private Pago pago;
    
}