/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.hotel.SERVICES;

import com.proyecto.hotel.DAO.TipoServicioDAO;
import com.proyecto.hotel.ENTITIES.TipoServicio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TipoServicioIMPLEMENT implements  TipoServicioSERVICE{

    @Autowired
    private  TipoServicioDAO TipoServicioDao;
    
    @Override
    @Transactional(readOnly = true)
    public List<TipoServicio> listaTipoServicio() {
        return (List<TipoServicio>)TipoServicioDao.findAll();
    }

    @Override
    public TipoServicio buscarTipoServicio(TipoServicio tipoServicio) {
        return TipoServicioDao.findById(tipoServicio.getCod_tip_serv()).orElse(null);
    }
    
}
