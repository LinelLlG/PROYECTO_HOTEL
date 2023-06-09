package com.proyecto.hotel.CONTROLLERS;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class ControladorPrincipal {
    
    /*-------------- INICIO -------------*/
     @GetMapping("/")
    public String inicio(Model model, @AuthenticationPrincipal User user){        
        log.info("Ejectuando el controlador Spring MVC");
        log.info("usuario que hizo login: " + user );
        
        return "layout";
    }
    
    /*----------------CRUD HABITACIONES----------------*/
    
    
}