package com.proyecto.hotel.SERVICES;

import com.proyecto.hotel.ENTITIES.Cargo;
import java.util.List;

public interface CargoSERVICE {
    public List<Cargo> listarCargo();
    public Cargo buscarCargo(Cargo cargo);
}
