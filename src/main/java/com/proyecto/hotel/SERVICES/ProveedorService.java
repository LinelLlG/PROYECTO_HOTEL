package com.proyecto.hotel.SERVICES;

import com.proyecto.hotel.ENTITIES.Proveedor;
import java.util.List;

public interface ProveedorService {
    
    public List<Proveedor> listarProveedor();
    
    public Proveedor buscarProveedor(Proveedor proveedor);
    
    public void guardarProveedor(Proveedor proveedor);
    
    public void eliminarProveedor(Proveedor proveedor);
    
}
