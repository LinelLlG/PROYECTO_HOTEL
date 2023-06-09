package com.proyecto.hotel.SERVICES;

import com.proyecto.hotel.DAO.PisosDAO;
import com.proyecto.hotel.ENTITIES.Pisos;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PisosIMPLEMENT implements PisosSERVICE{
    
    @Autowired
    private PisosDAO pisosDao;

    @Override
    @Transactional(readOnly = true)
    public List<Pisos> listarPisos() {
        return (List<Pisos>)pisosDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Pisos buscarPisos(Pisos pisos) {
        return pisosDao.findById(pisos.getCod_pis()).orElse(null);
    }
    
}
