/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.hotel.SERVICES;

import com.proyecto.hotel.DAO.SedeDAO;
import com.proyecto.hotel.ENTITIES.Pais;
import com.proyecto.hotel.ENTITIES.Sede;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Jotace
 */
@Service
public class SedeImplement implements SedeService{
    
     @Autowired
    private SedeDAO sedeDAO;
    
    @Override
    @Transactional(readOnly = true)
    public List<Sede> listarSede() {
        return sedeDAO.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Sede buscarSede(Sede sede) {
        return sedeDAO.findById(sede.getCod_sed()).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Sede> listSedeByPais(Long codPais) {
        return sedeDAO.listCiuByPais(codPais);
    }
    

}
