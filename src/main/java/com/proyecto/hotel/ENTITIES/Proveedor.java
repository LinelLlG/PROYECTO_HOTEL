package com.proyecto.hotel.ENTITIES;

import java.io.Serializable;
import java.time.LocalDate;
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
@Table(name = "tb_proveedor")
public class Proveedor implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cod_prov;
    private String ruc_prov;
    private String nom_prov;
    private String rep_legal_prov;
    private String dir_prov;
    private String tlf_prov;
    private String email_prov;
    private LocalDate fec_reg_prov;
    private String suc_prov;

    @ManyToOne
    @JoinColumn(name="cod_sed")
    private Sede sede;


    @ManyToOne
    @JoinColumn(name="cod_pais")
    private Pais pais;

    @OneToMany(mappedBy = "proveedor")
    private List<Stock> listaStock;

    @ManyToOne
    @JoinColumn(name="cod_disp")
    private Disponibilidad disponibilidad;
    
}