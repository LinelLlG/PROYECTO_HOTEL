package com.proyecto.hotel.SERVICES;

import com.proyecto.hotel.DAO.ReservaDAO;
import com.proyecto.hotel.ENTITIES.Reserva;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ReservaIMPLEMENT implements ReservaSERVICE{
    
    @Autowired
    private ReservaDAO reservaDao;

    @Override
    @Transactional(readOnly = true)
    public List<Reserva> listarReservas() {
        return (List<Reserva>)reservaDao.findAll();
    }

    @Override
    @Transactional
    public void guardarReservas(Reserva reserva) {
        reservaDao.save(reserva);
    }

    @Override
    @Transactional
    public void eliminarReservas(Reserva reserva) {
        reservaDao.delete(reserva);
    }

    @Override
    @Transactional(readOnly = true)
    public Reserva buscarReservas(Reserva reserva) {
        return reservaDao.findById(reserva.getCod_res()).orElse(null);
    }
    
}
