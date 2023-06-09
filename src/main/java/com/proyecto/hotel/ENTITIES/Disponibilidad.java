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
@Table(name = "tb_disponibilidad")
public class Disponibilidad implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cod_disp;
    
    private String disponibilidad;
    
        @OneToMany(mappedBy = "disponibilidad")
        private List<Habitaciones> listaHabitaciones;
    
	@OneToMany(mappedBy = "disponibilidad")
	private List<Servicio> listaServicio;
	
	@OneToMany(mappedBy = "disponibilidad")
	private List<Stock> listaStock;
	
	@OneToMany(mappedBy = "disponibilidad")
	private List<Proveedor> listaProveedor;
	
	@OneToMany(mappedBy = "disponibilidad")
	private List<Empleado> listaEmpleado;

	@OneToMany(mappedBy = "disponibilidad")
	private List<Clientes> listaClientes;
    
}