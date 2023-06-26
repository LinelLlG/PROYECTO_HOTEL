package com.proyecto.hotel.ENTITIES;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name = "tb_tip_servicio")
public class TipoServicio implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
        @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long cod_tip_serv;
        
	private String nom_tip_serv;
	
        @JsonIgnore
	@OneToMany(mappedBy = "tipoServicio")
	private List<Servicio> listaServicio;
    
}