/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.hotel.ENTITIES;

import lombok.Data;

/**
 *
 * @author Jotace
 */

@Data
public class Detalle {
    private int codigo,cantidad;
	private String nombre;
	private double precio;
}
