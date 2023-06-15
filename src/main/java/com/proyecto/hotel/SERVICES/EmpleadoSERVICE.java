/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.hotel.SERVICES;

import com.proyecto.hotel.ENTITIES.Empleado;
import java.util.List;

/**
 *
 * @author Jan
 */
public interface EmpleadoSERVICE {
    
    public List<Empleado> listarEmpleados();
    
    public void guardarEmpleados(Empleado empleado);
    
    public void eliminarEmpleados(Empleado empleado);
    
    public Empleado buscarEmpleado(Empleado empleado);
    
}
