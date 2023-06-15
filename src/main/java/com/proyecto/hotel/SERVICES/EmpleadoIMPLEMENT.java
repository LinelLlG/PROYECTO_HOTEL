/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.hotel.SERVICES;

import com.proyecto.hotel.DAO.EmpleadoDAO;
import com.proyecto.hotel.ENTITIES.Empleado;
import org.springframework.stereotype.Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmpleadoIMPLEMENT implements EmpleadoSERVICE{
    
    @Autowired
    private EmpleadoDAO empleadoDAO;
    

    @Override
    @Transactional(readOnly = true)
    public List<Empleado> listarEmpleados() {
        return empleadoDAO.findAll();
    }

    @Override
    @Transactional
    public void guardarEmpleados(Empleado empleado) {
        empleadoDAO.save(empleado);
    }

    @Override
    @Transactional
    public void eliminarEmpleados(Empleado empleado) {
        empleadoDAO.delete(empleado);
    }

    @Override
    @Transactional(readOnly = true)
    public Empleado buscarEmpleado(Empleado empleado) {
       return empleadoDAO.findById(empleado.getCod_emp()).orElse(null);
    }
    
   
}
