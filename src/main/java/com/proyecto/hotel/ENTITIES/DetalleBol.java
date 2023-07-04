/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.hotel.ENTITIES;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;

/**
 *
 * @author Jotace
 */
@Data
@Entity
@Table(name="tb_det_boleta")
public class DetalleBol implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
        @EmbeddedId
	private DetalleBolPK pk;
	
	@ManyToOne
	@JoinColumn(name="cod_stock",referencedColumnName = "cod_stock",insertable = false,updatable =false)
	private Stock stock;
	
	@ManyToOne
	@JoinColumn(name="cod_bol",referencedColumnName = "cod_bol",insertable = false,updatable =false)
	private Boleta boleta;
	
	private Double precio;
	private int cantidad;
        
       
    
}
