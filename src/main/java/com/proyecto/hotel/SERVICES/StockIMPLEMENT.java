/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.hotel.SERVICES;

import com.proyecto.hotel.DAO.StockDAO;
import com.proyecto.hotel.ENTITIES.Stock;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Nefi Alvarado
 */
@Service
public class StockIMPLEMENT implements StockSERVICE{

    @Autowired
    private StockDAO  stockDao;
    
    @Override
    @Transactional(readOnly = true)
    public List<Stock> listarStock() {
        return stockDao.findAll();
    }

    @Override
    public void guardarStock(Stock stock) {
        stockDao.save(stock);
    }

    @Override
    public void eliminarStock(Stock stock) {
        stockDao.delete(stock);
    }

    @Override
    @Transactional(readOnly = true)
    public Stock buscarStock(Stock stock) {
        return stockDao.findById(stock.getCod_stock()).orElse(null);
    }
    
}
