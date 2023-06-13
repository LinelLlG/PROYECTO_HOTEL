package com.proyecto.hotel.SERVICES;

import com.proyecto.hotel.ENTITIES.Clientes;
import java.util.List;

public interface ClientesSERVICE {
    
    public List<Clientes> listarClientes();
    
    public void guardarClientes(Clientes clientes);
    
    public void eliminarClientes(Clientes clientes);
    
    public Clientes bucarClientes(Clientes clientes);
    
}
