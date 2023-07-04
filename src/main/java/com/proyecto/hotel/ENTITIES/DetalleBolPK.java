/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.hotel.ENTITIES;

import java.io.Serializable;
import javax.persistence.Embeddable;
import lombok.Data;

/**
 *
 * @author Jotace
 */

@Data
@Embeddable
public class DetalleBolPK implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    private int cod_bol;
    private int cod_stock;

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + this.cod_bol;
        hash = 29 * hash + this.cod_stock;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final DetalleBolPK other = (DetalleBolPK) obj;
        if (this.cod_bol != other.cod_bol) {
            return false;
        }
        return this.cod_stock == other.cod_stock;
    }
        
    
        
       
    
}
