/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.hotel.SERVICES;

import com.proyecto.hotel.DAO.PaisDAO;
import com.proyecto.hotel.ENTITIES.Pais;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Jotace
 */
@Service
public class PaisImplement implements PaisService{

    @Autowired
    private PaisDAO paisDAO;
    
    @Override
    @Transactional(readOnly = true)
    public List<Pais> listarPais() {
        return paisDAO.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Pais buscarPais(Pais pais) {
        return paisDAO.findById(pais.getCod_pais()).orElse(null);
    }
    
}
