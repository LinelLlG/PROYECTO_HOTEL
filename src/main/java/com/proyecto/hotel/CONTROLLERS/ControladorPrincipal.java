package com.proyecto.hotel.CONTROLLERS;

import com.proyecto.hotel.ENTITIES.Clientes;
import com.proyecto.hotel.ENTITIES.Habitaciones;
import com.proyecto.hotel.SERVICES.ClientesSERVICE;
import com.proyecto.hotel.SERVICES.DisponibilidadSERVICE;
import com.proyecto.hotel.SERVICES.HabitacionesSERVICE;
import com.proyecto.hotel.SERVICES.PabellonSERVICE;
import com.proyecto.hotel.SERVICES.PisosSERVICE;
import com.proyecto.hotel.SERVICES.TipoClienteSERVICE;
import com.proyecto.hotel.SERVICES.TipoHabitacionSERVICE;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class ControladorPrincipal {
    
    @Autowired
    private HabitacionesSERVICE habitacionesService;
    
    @Autowired
    private ClientesSERVICE clientesService;
    
    @Autowired
    private TipoClienteSERVICE tipoClienteService;
    
    @Autowired
    private PisosSERVICE pisosService;
    
    @Autowired
    private DisponibilidadSERVICE disponibilidadService;
    
    @Autowired
    private PabellonSERVICE pabellonService;
    
    @Autowired
    private TipoHabitacionSERVICE tipoHabitacionService;
    
    /*-------------- INICIO -------------*/
     @GetMapping("/")
    public String inicio(Model model, @AuthenticationPrincipal User user){        
        log.info("Ejectuando el controlador Spring MVC");
        log.info("usuario que hizo login: " + user );
        
        return "layout";
    }
    
    /*----------------CRUD HABITACIONES----------------*/
    @GetMapping("/habitaciones")
    public String listarHabitaciones(Model model){
        var habitaciones = habitacionesService.listarHabitaciones();
        model.addAttribute("habitaciones", habitaciones);
        return "listarHabitaciones";
    }
    
    @GetMapping("/agregarHabitaciones")
    public String agregarHabitaciones(Habitaciones habitaciones, Model model){
        var disponibilidad = disponibilidadService.listarDisponibilidad();
        model.addAttribute("disponibilidad", disponibilidad);
        var pabellon = pabellonService.listarPabellon();
        model.addAttribute("pabellon", pabellon);
        var pisos = pisosService.listarPisos();
        model.addAttribute("pisos", pisos);
        var tipoHabitacion = tipoHabitacionService.listarTipoHabitacion();
        model.addAttribute("tipoHabitacion", tipoHabitacion);
        
        model.addAttribute("habitaciones", habitaciones);
        return "mantenimientoHabitaciones";
    }
    
    @PostMapping("/guardarHabitaciones")
    public String guardarHabitaciones(Habitaciones habitaciones){
        habitacionesService.guardarHabitaciones(habitaciones);
        return "redirect:/habitaciones";
    }
    
    @GetMapping("/editarHabitaciones/{cod_hab}")
    public String editarHabitaciones(Habitaciones habitaciones, Model model){
        var disponibilidad = disponibilidadService.listarDisponibilidad();
        model.addAttribute("disponibilidad", disponibilidad);
        var pabellon = pabellonService.listarPabellon();
        model.addAttribute("pabellon", pabellon);
        var pisos = pisosService.listarPisos();
        model.addAttribute("pisos", pisos);
        var tipoHabitacion = tipoHabitacionService.listarTipoHabitacion();
        model.addAttribute("tipoHabitacion", tipoHabitacion);
        
        habitaciones = habitacionesService.buscarHabitaciones(habitaciones);
        model.addAttribute("habitaciones", habitaciones);
        
        return "mantenimientoHabitaciones";
    }
    
    @GetMapping("eliminarHabitaciones/{cod_hab}")
    public String eliminarHabitaciones(Habitaciones habitaciones){
        habitacionesService.eliminarHabitaciones(habitaciones);
        return "redirect:/habitaciones";
    }
    
    /*------------------ CRUD CLIENTES ----------------*/
    
    @GetMapping("/clientes")
    public String listarClientes(Model model){
        var clientes = clientesService.listarClientes();
        model.addAttribute("clientes", clientes);
        return "listarClientes";
    }
    
    @GetMapping("/agregarClientes")
    public String agregarClientes(Clientes clientes, Model model){
        var tipoCliente = tipoClienteService.listarTipoCliente();
        model.addAttribute("tipoCliente", tipoCliente);
        var disponibilidad = disponibilidadService.listarDisponibilidad();
        model.addAttribute("disponibilidad", disponibilidad);
        
        model.addAttribute("clientes", clientes);
        return "mantenimientoClientes";
    }
    
    @GetMapping("/guardarClientes")
    public String guardarClientes(Clientes clientes){
        clientesService.guardarClientes(clientes);
        return "redirect:/clientes";
    }
    
    @GetMapping("/editarClientes/{cod_cli}")
    public String editarClientes(Clientes clientes, Model model){
        clientes = clientesService.bucarClientes(clientes);
        model.addAttribute("clientes", clientes);
        var tipoCliente = tipoClienteService.listarTipoCliente();
        model.addAttribute("tipoCliente", tipoCliente);
        var disponibilidad = disponibilidadService.listarDisponibilidad();
        model.addAttribute("disponibilidad", disponibilidad);
        return "listarClientes";
    }
    
    @GetMapping("eliminarClientes/{cod_cli}")
    public String eliminarClientes(Clientes clientes){
        clientesService.eliminarClientes(clientes);
        return "redirect:/clientes";
    }
    
}