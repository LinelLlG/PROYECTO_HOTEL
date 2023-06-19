package com.proyecto.hotel.ENTITIES;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "tb_estado")
public class Estado implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cod_est;

    private String des_est;

    @OneToMany(mappedBy = "estado")
    private List<Reserva> reserva;

}