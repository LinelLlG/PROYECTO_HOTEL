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
@Table(name = "tb_stock")
public class Stock implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cod_stock;
    private String nom_stock;
    private Long cant_stock;

    @ManyToOne
    @JoinColumn(name = "cod_tip_stock")
    private TipoStock tipoStock;

    private Double pre_venta_stock;

    private Double pre_compra_stock;

    @ManyToOne
    @JoinColumn(name = "cod_prov")
    private Proveedor proveedor;

    @ManyToOne
    @JoinColumn(name="cod_disp")
    private Disponibilidad disponibilidad;

    public Stock() {
    }
    
    

    public Stock(int codigo) {
        this.cod_stock = codigo;
    }
    
}