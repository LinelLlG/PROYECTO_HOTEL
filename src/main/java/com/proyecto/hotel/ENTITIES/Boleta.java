/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.hotel.ENTITIES;

import java.io.Serializable;
import java.util.Date;
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

/**
 *
 * @author Jotace
 */
@Data
@Entity
@Table(name="tb_boleta")
public class Boleta implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
        @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cod_bol;
	
	private Date fecha;
	
	private double total_bol;
	
	@ManyToOne
	@JoinColumn(name = "cod_cli")
	private Clientes clientes;
	
	@ManyToOne
	@JoinColumn(name = "cod_usuarios")
	private Usuarios usuario;
	
	@OneToMany(mappedBy = "boleta")
	private List<DetalleBol> listaDetallebol;
    
}
