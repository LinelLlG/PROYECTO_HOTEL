package com.proyecto.hotel.ENTITIES;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class Disponibilidad implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cod_disp;

    private String disponibilidad;

    @JsonIgnore
    @OneToMany(mappedBy = "disponibilidad")
    private List<Habitaciones> listaHabitaciones;

    @JsonIgnore
    @OneToMany(mappedBy = "disponibilidad")
    private List<Servicio> listaServicio;

    @JsonIgnore
    @OneToMany(mappedBy = "disponibilidad")
    private List<Stock> listaStock;

    @JsonIgnore
    @OneToMany(mappedBy = "disponibilidad")
    private List<Proveedor> listaProveedor;

    @JsonIgnore
    @OneToMany(mappedBy = "disponibilidad")
    private List<Empleado> listaEmpleado;

    @JsonIgnore
    @OneToMany(mappedBy = "disponibilidad")
    private List<Clientes> listaClientes;

}
