/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.hotel.SERVICES;

import com.proyecto.hotel.DAO.TipoStockDAO;
import com.proyecto.hotel.ENTITIES.TipoStock;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Nefi Alvarado
 */
@Service
public class TipoStockIMPLEMENT implements TipoStockSERVICE{

    @Autowired
    private TipoStockDAO TipoStockDao;
    
    @Override
    @Transactional(readOnly = true)
    public List<TipoStock> listaTipoStock() {
        return (List<TipoStock>)TipoStockDao.findAll();
    }

    @Override
    public TipoStock buscarTipoStock(TipoStock tipoStock) {
    return TipoStockDao.findById(tipoStock.getCod_tip_stock()).orElse(null);
    }
    
}
