/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.hotel.SERVICES;

import com.proyecto.hotel.DAO.ServicioDAO;
import com.proyecto.hotel.ENTITIES.Servicio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ServicioIMPLENT implements ServicioSERVICE{

    @Autowired
    private ServicioDAO servicioDao;
    
    @Override
    @Transactional(readOnly = true)
    public List<Servicio> listarServicio() {
       return servicioDao.findAll();
    }

    @Override
    public void guardarServicio(Servicio servicio) {
        servicioDao.save(servicio);
    }

    @Override
    public void eliminarServicio(Servicio servicio) {
        servicioDao.delete(servicio);
    }

    @Override
    @Transactional(readOnly = true)
    public Servicio buscarServicio(Servicio servicio) {
        return servicioDao.findById(servicio.getCod_serv()).orElse(null);
    }
    

}
