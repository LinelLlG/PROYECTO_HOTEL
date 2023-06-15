/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.hotel.SERVICES;

import com.proyecto.hotel.DAO.ProveedorDAO;
import com.proyecto.hotel.ENTITIES.Proveedor;
import com.proyecto.hotel.ENTITIES.Sede;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Jotace
 */
@Service
public class ProveedorImplement implements ProveedorService{
    
    @Autowired
    private ProveedorDAO proveedorDAO;

    @Override
    @Transactional(readOnly = true)
    public List<Proveedor> listarProveedor() {
        return proveedorDAO.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Proveedor buscarProveedor(Proveedor proveedor) {
        return proveedorDAO.findById(proveedor.getCod_prov()).orElse(null);
    }

    @Override
    @Transactional
    public void guardarProveedor(Proveedor proveedor) {
        proveedorDAO.save(proveedor);
    }

    @Override
    @Transactional
    public void eliminarProveedor(Proveedor proveedor) {
         proveedorDAO.delete(proveedor);
    }
    
    
    
}
