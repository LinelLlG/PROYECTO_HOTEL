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
@Table(name = "tb_clientes")
public class Clientes implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cod_cli;
    
    private String nom_cli;
    private String ape_cli;
    private String dni_cli;
    private String ruc_cli;
    private String cel_cli;
    private String email_cli;
    private String dir_cli;


    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="cod_tip_cli")
    private TipoCliente tipoCliente;
    
    @JsonIgnore
    @OneToMany(mappedBy = "clientes")
    private List<Reserva> listaReserva;
/*
    @OneToMany(mappedBy = "clientes")
    private List<Boleta> listaBoletas;
    */
    @ManyToOne
    @JoinColumn(name="cod_disp")
    private Disponibilidad disponibilidad;

    public Clientes() {
    }
    
    

    public Clientes(Long codClie) {
        this.cod_cli = codClie;
    }

}