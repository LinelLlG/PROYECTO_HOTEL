/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.hotel.SERVICES;

import com.proyecto.hotel.ENTITIES.Cargo;
import java.util.List;


public interface CargoSERVICE {
    public List<Cargo> listarCargo();
    public Cargo buscarCargo(Cargo cargo);
}
