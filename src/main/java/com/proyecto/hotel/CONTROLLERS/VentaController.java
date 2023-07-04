/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.hotel.CONTROLLERS;

import com.proyecto.hotel.ENTITIES.Boleta;
import com.proyecto.hotel.ENTITIES.Clientes;
import com.proyecto.hotel.ENTITIES.Detalle;
import com.proyecto.hotel.ENTITIES.DetalleBol;
import com.proyecto.hotel.ENTITIES.Pago;
import com.proyecto.hotel.ENTITIES.Stock;
import com.proyecto.hotel.ENTITIES.Usuarios;
import com.proyecto.hotel.SERVICES.BoletaService;
import com.proyecto.hotel.SERVICES.ClientesSERVICE;
import com.proyecto.hotel.SERVICES.StockSERVICE;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author Jotace
 */
@Controller
@Slf4j
public class VentaController {
    
        @Autowired
	private StockSERVICE serviStock;
	
	@Autowired
	private ClientesSERVICE serviCliente;
	
	@Autowired
	private BoletaService serviBol;
        
        
        @GetMapping("/boleta")
        public String boleta(Model model){
            var stock = serviStock.listarStock();
            model.addAttribute("stock", stock);
        return "boleta";
        }
        
        
        @RequestMapping("/adicionar")
	@ResponseBody
	public List<Detalle> adicionar(@RequestParam("codigo") int cod,
                                        @RequestParam("nombre") String nom,
					@RequestParam("cantidad") int cant,
					@RequestParam("precio") double pre,
					 HttpSession session) {
	
		List<Detalle> lista = null;
		
		if(session.getAttribute("carrito") == null) 
			lista = new ArrayList<Detalle>();
		
		else
			lista = (List<Detalle>)session.getAttribute("carrito");
			
		
		Detalle det = new Detalle();
		det.setCodigo(cod);
		det.setNombre(nom);
		det.setCantidad(cant);
		det.setPrecio(pre);
		lista.add(det);
		
		session.setAttribute("carrito", lista);
		
		
		return lista;
	
	}
        
        @RequestMapping("/eliminar")
	@ResponseBody
	public List<Detalle> eliminar(@RequestParam("codigo") int cod,
							HttpSession session) {
		List<Detalle> lista = (List<Detalle>)session.getAttribute("carrito");
		
		//bucle
		
		for(Detalle det : lista) {
			if(det.getCodigo()==cod) {
				lista.remove(det);
				break;
			}
		}
		
		session.setAttribute("carrito", lista);
		
		return lista;
	}
        
        @GetMapping("/findPorApe2/{apellido}")
	@ResponseBody
	public List<Clientes> findPorApe2(@PathVariable("apellido") String ape) {
		List<Clientes> data = serviCliente.listAllByPaterno(ape+"%");
		return data;
	}
        
        @PostMapping("/grabarBoleta")
	public String grabar(@RequestParam("codClie") Long codClie,
							@SessionAttribute("CODIGOUSUARIO") Long codUsu,
							@RequestParam("fecha") String fecha,
							@RequestParam("total") double total,
							@RequestParam("pago") Long  pago2,
							RedirectAttributes redirect,
							HttpSession sesion) {
		
		try {
			Boleta bean = new Boleta();
			
			bean.setClientes(new Clientes(codClie));
			bean.setUsuario(new Usuarios(codUsu));
			bean.setFecha(Date.valueOf(fecha));
			bean.setTotal_bol(total);
			
			List<Detalle> lista = (List<Detalle>) sesion.getAttribute("carrito");
			
			List<DetalleBol> data = new ArrayList<DetalleBol>();
			
			for(Detalle d : lista) {
				DetalleBol db = new DetalleBol();
				db.setStock(new Stock(d.getCodigo()));
				db.setCantidad(d.getCantidad());
				db.setPrecio(d.getPrecio());
                                
                                
				
				data.add(db);
			}
                        
                        
                        
			bean.setListaDetallebol(data);
			
			
			serviBol.guardarClientes(bean);
			
			lista.clear();
			sesion.setAttribute("carrito", lista);
			
		} catch (Exception e) {
			// TODO: handle exception
			
			e.printStackTrace();
		}
		
		
		
		return "redirect:/boleta";
	}
    
}
