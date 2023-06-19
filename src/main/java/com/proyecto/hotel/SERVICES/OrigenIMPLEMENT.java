package com.proyecto.hotel.SERVICES;

import com.proyecto.hotel.DAO.OrigenDAO;
import com.proyecto.hotel.ENTITIES.Origen;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrigenIMPLEMENT implements OrigenSERVICE{
    
    @Autowired
    private OrigenDAO origenDao;

    @Override
    @Transactional(readOnly = true)
    public List<Origen> listarOrigen() {
        return (List<Origen>)origenDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Origen buscarOrigen(Origen origen) {
        return origenDao.findById(origen.getCod_orig()).orElse(null);
    }
    
}
