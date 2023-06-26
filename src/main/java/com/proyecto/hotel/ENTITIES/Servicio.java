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
@Table(name = "tb_servicio")
public class Servicio implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cod_serv;
    private String des_serv;

    private Double pre_serv;

    @ManyToOne
    @JoinColumn(name = "cod_tip_serv")
    private TipoServicio tipoServicio;

    @ManyToOne
    @JoinColumn(name="cod_disp")
    private Disponibilidad disponibilidad;
    
}