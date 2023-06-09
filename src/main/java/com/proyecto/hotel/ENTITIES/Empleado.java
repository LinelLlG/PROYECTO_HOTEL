package com.proyecto.hotel.ENTITIES;

import java.io.Serializable;
import java.time.LocalDate;
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
@Table(name = "tb_empleado")
public class Empleado implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cod_emp;

    private String nom_emp;
    private String ape_emp;
    private String dni_emp;
    private String email_emp;
    private String cel_emp;
    private String dir_emp;
    private LocalDate fec_nac_emp;
    private int hijos_emp;
    private String prof_emp;
    private double sueldo_emp;


    @ManyToOne
    @JoinColumn(name="cod_crg")
    private Cargo cargo;

    @ManyToOne
    @JoinColumn(name="cod_con")
    private TipoContrato tipoContrato;

    @ManyToOne
    @JoinColumn(name="cod_disp")
    private Disponibilidad disponibilidad;
    
}