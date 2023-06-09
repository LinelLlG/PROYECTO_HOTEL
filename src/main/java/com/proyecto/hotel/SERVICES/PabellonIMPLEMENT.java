package com.proyecto.hotel.SERVICES;

import com.proyecto.hotel.DAO.PabellonDAO;
import com.proyecto.hotel.ENTITIES.Pabellon;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PabellonIMPLEMENT implements PabellonSERVICE{
    
    @Autowired
    private PabellonDAO pabellonDao;

    @Override
    @Transactional(readOnly = true)
    public List<Pabellon> listarPabellon() {
        return (List<Pabellon>)pabellonDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Pabellon buscarPabellon(Pabellon pabellon) {
        return pabellonDao.findById(pabellon.getCod_pab()).orElse(null);
    }
    
}
