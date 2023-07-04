package com.proyecto.hotel.CONTROLLERS;

import com.proyecto.hotel.ENTITIES.Clientes;
import com.proyecto.hotel.ENTITIES.Disponibilidad;
import com.proyecto.hotel.ENTITIES.Empleado;
import com.proyecto.hotel.ENTITIES.Habitaciones;
import com.proyecto.hotel.ENTITIES.Proveedor;
import com.proyecto.hotel.ENTITIES.Reserva;
import com.proyecto.hotel.ENTITIES.Sede;
import com.proyecto.hotel.ENTITIES.Servicio;
import com.proyecto.hotel.ENTITIES.Stock;
import com.proyecto.hotel.ENTITIES.Usuarios;
import com.proyecto.hotel.SERVICES.CargoSERVICE;
import com.proyecto.hotel.SERVICES.ClientesSERVICE;
import com.proyecto.hotel.SERVICES.DisponibilidadSERVICE;
import com.proyecto.hotel.SERVICES.EmpleadoSERVICE;
import com.proyecto.hotel.SERVICES.EstadoSERVICE;
import com.proyecto.hotel.SERVICES.HabitacionesSERVICE;
import com.proyecto.hotel.SERVICES.OrigenSERVICE;
import com.proyecto.hotel.SERVICES.PabellonSERVICE;
import com.proyecto.hotel.SERVICES.PagoSERVICE;
import com.proyecto.hotel.SERVICES.PaisService;
import com.proyecto.hotel.SERVICES.PisosSERVICE;
import com.proyecto.hotel.SERVICES.ProveedorService;
import com.proyecto.hotel.SERVICES.ReservaSERVICE;
import com.proyecto.hotel.SERVICES.SedeService;
import com.proyecto.hotel.SERVICES.ServicioSERVICE;
import com.proyecto.hotel.SERVICES.StockSERVICE;
import com.proyecto.hotel.SERVICES.TipoClienteSERVICE;
import com.proyecto.hotel.SERVICES.TipoContratoSERVICE;
import com.proyecto.hotel.SERVICES.TipoHabitacionSERVICE;
import com.proyecto.hotel.SERVICES.TipoServicioSERVICE;
import com.proyecto.hotel.SERVICES.TipoStockSERVICE;
import com.proyecto.hotel.SERVICES.UsuariosSERVICE;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

@SessionAttributes({"ENLACES","CODIGOUSUARIO"})
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
    
    @Autowired
    private ServicioSERVICE servicioService;
    
    @Autowired
    private StockSERVICE stockService;
    
    @Autowired
    private TipoStockSERVICE tipoStockService;
    
    @Autowired 
    private TipoServicioSERVICE tipoServicioService;
    
    @Autowired
    private EmpleadoSERVICE empleadoSERVICE;
    
    @Autowired
    private CargoSERVICE cargoSERVICE;
    
    @Autowired
    private TipoContratoSERVICE tipoContratoSERVICE;
    
    @Autowired
    private ProveedorService proveedorService;
    
    @Autowired
    private SedeService sedeService;
    
     @Autowired
    private PaisService paisService;
     
     @Autowired
     private EstadoSERVICE estadoService;
     
     @Autowired
     private OrigenSERVICE origenService;
     
     @Autowired
     private PagoSERVICE pagoService;
     
     @Autowired
     private ReservaSERVICE reservaService;
     
     @Autowired
     private UsuariosSERVICE usuarioService;
    
    /*-------------- INICIO -------------*/
    
     @GetMapping("/")
    public String inicio(Model model, @AuthenticationPrincipal User user){        
        log.info("Ejectuando el controlador Spring MVC");
        log.info("usuario que hizo login: " + user );
        String vPerfil = user.getUsername();
         Usuarios usu = usuarioService.loginPerfil(vPerfil);
       model.addAttribute("CODIGOUSUARIO", usu.getCod_usuarios());
        
        return "dashboard";
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
    
    @PostMapping("/guardarClientes")
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
        return "mantenimientoClientes";
    }
    
    @GetMapping("eliminarClientes/{cod_cli}")
    public String eliminarClientes(Clientes clientes){
        clientesService.eliminarClientes(clientes);
        return "redirect:/clientes";
    }
    
    /*------------------ CRUD SERVICIO ----------------*/
    
    @GetMapping("/servicio")
    public String listarServicio(Model model){
       var servicio = servicioService.listarServicio();
       model.addAttribute("servicio", servicio);
        return "listarServicios";     
    }
    
    @GetMapping("/agregarServicio")
    public String agregarServicio(Servicio servicio , Model model){
        var tipoServicio = tipoServicioService.listaTipoServicio();
        model.addAttribute("tipoServicio", tipoServicio);
        var disponibilidad = disponibilidadService.listarDisponibilidad();
        model.addAttribute("disponibilidad", disponibilidad);
        
        model.addAttribute("servicio", servicio);
        return "mantenimientoServicio";    
    }
    
    @PostMapping("/guardarServicio")
    public String guardarServicio(Servicio servicio){
        servicioService.guardarServicio(servicio);
        return "redirect:/servicio";
    }
    
    @GetMapping("/editarServicio/{cod_serv}")
    public String editarServicio(Servicio servicio , Model model){
        servicio = servicioService.buscarServicio(servicio);
        model.addAttribute("servicio", servicio);
        var tipoServicio = tipoServicioService.listaTipoServicio();
        model.addAttribute("tipoServicio", tipoServicio);
        var disponibilidad = disponibilidadService.listarDisponibilidad();
        model.addAttribute("disponibilidad", disponibilidad);
        return "mantenimientoServicio";      
    }
    
    @GetMapping("/eliminarServicio/{cod_serv}")
    public String eliminarservicio(Servicio servicio){
        servicioService.eliminarServicio(servicio);
        return "redirect:/servicio";
    }
    
    /*------------------ CRUD STOCK ----------------*/
    @GetMapping("/stock")
    public String listarStock(Model model){
       var stock = stockService.listarStock();
       model.addAttribute("stock", stock);
        return "listarStocks";     
    }
    
    @GetMapping("/agregarStock")
    public String agregarStock(Stock stock , Model model){
        var tipoStock = tipoStockService.listaTipoStock();
        model.addAttribute("tipoStock", tipoStock);
        var proveedor = proveedorService.listarProveedor();
        model.addAttribute("proveedor",proveedor);
        var disponibilidad = disponibilidadService.listarDisponibilidad();
        model.addAttribute("disponibilidad", disponibilidad);
        
        model.addAttribute("stock", stock);
        return "mantenimientoStock";    
    }
    
    @PostMapping("/guardarStock")
    public String guardarStock(Stock stock){
        stockService.guardarStock(stock);
        return "redirect:/stock";
    }
    
    @GetMapping("/editarStock/{cod_stock}")
    public String editarStock(Stock stock , Model model){
        stock = stockService.buscarStock(stock);
        model.addAttribute("stock", stock);
        var tipoStock = tipoStockService.listaTipoStock();
        model.addAttribute("tipoStock", tipoStock);
        var proveedor = proveedorService.listarProveedor();
        model.addAttribute("proveedor",proveedor);
        var disponibilidad = disponibilidadService.listarDisponibilidad();
        model.addAttribute("disponibilidad", disponibilidad);
        return "mantenimientoStock";      
    }
    
    @GetMapping("/eliminarStock/{cod_stock}")
    public String eliminarStock(Stock stock){
        stockService.eliminarStock(stock);
        return "redirect:/stock";
    }
    
    
    
    /*------------------ CRUD EMPLEADOS ----------------*/
    
    @GetMapping("/empleado")
    public String ListarEmpleados(Model model){
        var empleado = empleadoSERVICE.listarEmpleados();
        model.addAttribute("empleado", empleado);
        return "listarEmpleados";
    }
    
    @GetMapping("/agregarEmpleado")
    public String agregarEmpleado(Empleado empleado, Model model){
        var cargo = cargoSERVICE.listarCargo();
        model.addAttribute("cargo", cargo);
        var tipoContrato = tipoContratoSERVICE.listarTipoContrato();
        model.addAttribute("tipoContrato", tipoContrato);
        var disponibilidad = disponibilidadService.listarDisponibilidad();
        model.addAttribute("disponibilidad", disponibilidad);
        
        
        model.addAttribute("empleado", empleado);
        return "mantenimientoEmpleados";
    }
    
    @PostMapping("/guardarEmpleado")
    public String guardarEmpleado(Empleado empleado){
        empleadoSERVICE.guardarEmpleados(empleado);
        return "redirect:/empleado";
    }
    
    @GetMapping("/editarEmpleado/{cod_emp}")
    public String editarEmpleado(Empleado empleado, Model model){
        var cargo = cargoSERVICE.listarCargo();
        model.addAttribute("cargo", cargo);
        var tipoContrato = tipoContratoSERVICE.listarTipoContrato();
        model.addAttribute("tipoContrato", tipoContrato);
        var disponibilidad = disponibilidadService.listarDisponibilidad();
        model.addAttribute("disponibilidad", disponibilidad);
        
       
        empleado = empleadoSERVICE.buscarEmpleado(empleado);
        model.addAttribute("empleado", empleado);
        
        return "mantenimientoEmpleados";
    }
    
    @GetMapping("eliminarEmpleados/{cod_emp}")
    public String eliminarEmpleados(Empleado empleado){
        empleadoSERVICE.eliminarEmpleados(empleado);
        return "redirect:/empleado";
    }
    
    /*------------CRUD PROVEEDORES--------------*/
    
    @GetMapping("/proveedores")
    public String listarProveedores(Model model){
        
        var proveedores = proveedorService.listarProveedor();
        model.addAttribute("proveedor", proveedores);
        
        return "listarProveedores";
    }
    
    @GetMapping("/registrarProveedor")
    public String registrarProveedores(Proveedor proveedor, Model model){
        
        var pais = paisService.listarPais();
        var sede = sedeService.listarSede();
        
        model.addAttribute("pais", pais);
        model.addAttribute("sede", sede);
      
        return "mantenimientoProveedor";
    }
    
    
    @GetMapping("/editarProveedor/{cod_prov}")
    public String agregarProveedores(Proveedor proveedor, Model model){
        
        var pais = paisService.listarPais();
        var sede = sedeService.listarSede();
        proveedor = proveedorService.buscarProveedor(proveedor);
        
        model.addAttribute("pais", pais);
        model.addAttribute("sede", sede);
        model.addAttribute("proveedor", proveedor);
      
        return "mantenimientoProveedor";
    }
    
    @PostMapping("/guardarProveedor")
    public String guardarProveedor(Proveedor proveedor){
        var disp = new Disponibilidad();
        disp.setCod_disp(1L);
        proveedor.setDisponibilidad(disp);
        proveedorService.guardarProveedor(proveedor);
        return "redirect:/proveedores";
    }
    
    @GetMapping("/sede/{codigoPais}")
    @ResponseBody
    public List<Sede> obtenerSedes(@PathVariable("codigoPais") Long codigoPais) {
        List<Sede> sedes = sedeService.listSedeByPais(codigoPais);
        return sedes;
    }
    
    /*-----------------CRUD RESERVAS-----------------*/
    
    @GetMapping("/reserva")
    public String listarReservas(Model model){
        var reserva = reservaService.listarReservasGeneral();
        model.addAttribute("reserva", reserva);
        return "listarReservas";
    }
    
    @GetMapping("/reservaPrueba")
    public String listarReservasPrueba(Model model){
        var reserva = reservaService.listarReservasActivas();
        model.addAttribute("reserva", reserva);
        return "listarReservas";
    }
    
    @GetMapping("/agregarReserva")
    public String agregarReserva(Reserva reserva, Model model){
        var clientes = clientesService.listarClientes();
        model.addAttribute("clientes", clientes);
        var habitaciones = habitacionesService.listarHabitaciones();
        model.addAttribute("habitaciones", habitaciones);
        var estado = estadoService.listarEstado();
        model.addAttribute("estado", estado);
        var origen = origenService.listarOrigen();
        model.addAttribute("origen", origen);
        var pago = pagoService.listarPago();
        model.addAttribute("pago", pago);
        
        model.addAttribute("reserva", reserva);
        return "mantenimientoReserva";
    }
    
    @PostMapping("/guardarReserva")
    public String guardarReserva(Reserva reserva){
        reservaService.guardarReservas(reserva);
        return "redirect:/reservaPrueba";
    }
    
    @GetMapping("/editarReserva/{cod_res}")
    public String editarReserva(Reserva reserva, Model model){
        var clientes = clientesService.listarClientes();
        model.addAttribute("clientes", clientes);
        var habitaciones = habitacionesService.listarHabitaciones();
        model.addAttribute("habitaciones", habitaciones);
        var estado = estadoService.listarEstado();
        model.addAttribute("estado", estado);
        var origen = origenService.listarOrigen();
        model.addAttribute("origen", origen);
        var pago = pagoService.listarPago();
        model.addAttribute("pago", pago);
        
        reserva = reservaService.buscarReservas(reserva);
        model.addAttribute("reserva", reserva);
        return "mantenimientoReserva";
    }
    
        @GetMapping("/findPorApe/{apellido}")
	@ResponseBody
	public List<Clientes> findPorApe(@PathVariable("apellido") String ape) {
		List<Clientes> data = clientesService.listAllByPaterno(ape+"%");
		return data;
	}
    
        @GetMapping("/findPorNombre/{nombre}")
	@ResponseBody
	public List<Habitaciones> findPorNombre(@PathVariable("nombre") String nombre) {
		var data = habitacionesService.listAllByNombre(nombre+"%");
		return data;
	}
    
}