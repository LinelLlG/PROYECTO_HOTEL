/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.hotel.SERVICES;

import com.proyecto.hotel.DAO.BoletaRepository;
import com.proyecto.hotel.DAO.DetalleBolRepository;
import com.proyecto.hotel.ENTITIES.Boleta;
import com.proyecto.hotel.ENTITIES.DetalleBol;
import com.proyecto.hotel.ENTITIES.DetalleBolPK;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Jotace
 */

@Service
public class BoletaServiceImpl implements BoletaService{
    
    @Autowired
    private BoletaRepository repoBol;
	
    @Autowired
    private DetalleBolRepository repoDet;

    @Override
    @Transactional
    public void guardarClientes(Boleta bol) {
        try {
			
			//grabar cabecera "Boleta"
			repoBol.save(bol);
			//grabar detalle
			//bucle
			for(DetalleBol db: bol.getListaDetallebol()) {
				
				DetalleBolPK pk = new DetalleBolPK();
				pk.setCod_bol(bol.getCod_bol());
				pk.setCod_stock(db.getStock().getCod_stock());
				
				db.setPk(pk);
				
				repoDet.save(db);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
    }

    @Override
    @Transactional(readOnly = true)
    public List<Boleta> listar(int cod) {
        return repoBol.listAllByCod(cod);
    }
    
}
