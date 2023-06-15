/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.hotel.CONTROLLERS;

import com.proyecto.hotel.ENTITIES.Proveedor;
import com.proyecto.hotel.ENTITIES.Sede;
import com.proyecto.hotel.SERVICES.PaisService;
import com.proyecto.hotel.SERVICES.ProveedorService;
import com.proyecto.hotel.SERVICES.SedeService;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Jotace
 */

@Controller
@Slf4j
public class ProveedorController {
    
    @Autowired
    private ProveedorService proveedorService;
    
    @Autowired
    private SedeService sedeService;
    
     @Autowired
    private PaisService paisService;
    
    
    @GetMapping("/proveedores")
    public String listarProveedores(Model model){
        
        var proveedores = proveedorService.listarProveedor();
        model.addAttribute("proveedor", proveedores);
        
        return "listarProveedores";
    }
    
    @GetMapping("/agregarProveedor")
    public String agregarProveedores(Proveedor proveedor, Model model){
        
        var pais = paisService.listarPais();
        var sede = sedeService.listarSede();
        
        model.addAttribute("pais", pais);
       // model.addAttribute("sede", sede);
      
        return "mantenimientoProveedor";
    }
    
    @GetMapping("/ciudades/{codigoPais}")
    @ResponseBody
    public List<Sede> obtenerSedes(@PathVariable("codigoPais") Long codigoPais) {
        List<Sede> sedes = sedeService.listSedeByPais(codigoPais);
        return sedes;
    }
    
}
