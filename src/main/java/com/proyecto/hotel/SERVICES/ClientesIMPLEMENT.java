package com.proyecto.hotel.SERVICES;
        
import com.proyecto.hotel.DAO.ClientesDAO;
import com.proyecto.hotel.ENTITIES.Clientes;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClientesIMPLEMENT implements ClientesSERVICE{
    
    @Autowired
    private ClientesDAO clientesDao;

    @Override
    @Transactional(readOnly = true)
    public List<Clientes> listarClientes() {
        return clientesDao.findAll();
    }

    @Override
    @Transactional
    public void guardarClientes(Clientes clientes) {
        clientesDao.save(clientes);
    }

    @Override
    @Transactional
    public void eliminarClientes(Clientes clientes) {
        clientesDao.delete(clientes);
    }

    @Override
    @Transactional(readOnly = true)
    public Clientes bucarClientes(Clientes clientes) {
        return clientesDao.findById(clientes.getCod_cli()).orElse(null);
    }

    @Override
    @Transactional
    public List<Clientes> listAllByPaterno(String ape) {
        return clientesDao.listAllByPaterno(ape);
    }    
}
