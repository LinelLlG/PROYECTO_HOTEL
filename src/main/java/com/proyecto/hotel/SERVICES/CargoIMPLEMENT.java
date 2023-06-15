/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.hotel.SERVICES;

import com.proyecto.hotel.DAO.CargoDAO;
import com.proyecto.hotel.ENTITIES.Cargo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CargoIMPLEMENT implements CargoSERVICE{
    @Autowired
    private CargoDAO cargoDAO;

    @Override
    @Transactional(readOnly = true)
    public List<Cargo> listarCargo() {
        return (List<Cargo>)cargoDAO.findAll();
    }

    @Override
     @Transactional(readOnly = true)
    public Cargo buscarCargo(Cargo cargo) {
       return cargoDAO.findById(cargo.getCod_crg()).orElse(null);
    }
    
}
