package com.proyecto.hotel.SERVICES;

import com.proyecto.hotel.DAO.PagoDAO;
import com.proyecto.hotel.ENTITIES.Pago;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PagoIMPLEMENT implements PagoSERVICE{
    
    @Autowired
    private PagoDAO pagoDao;

    @Override
    @Transactional(readOnly = true)
    public List<Pago> listarPago() {
        return (List<Pago>)pagoDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Pago buscarPago(Pago pago) {
        return pagoDao.findById(pago.getCod_pago()).orElse(null);
    }
    
}
