/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyecto.hotel.UTILS;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 *
 * @author jaimePC
 */
public class EncriptarPassword {
    
    
    public static void main(String[] args) {
       
        
        var password = "456";
        
        System.out.println("password: " + password);
        System.out.println("password encriptado : " + encriptarPassword(password));
        
        
        
    }
    
    
    
    public static  String encriptarPassword(String password){
     BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        
        return encoder.encode(password)      ;
    
    }
    
    
}
