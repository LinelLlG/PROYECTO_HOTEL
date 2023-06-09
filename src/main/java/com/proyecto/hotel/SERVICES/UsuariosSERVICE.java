package com.proyecto.hotel.SERVICES;

import com.proyecto.hotel.DAO.UsuariosDAO;
import com.proyecto.hotel.ENTITIES.Roles;
import com.proyecto.hotel.ENTITIES.Usuarios;
import java.util.ArrayList;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("userDetailsService")
@Slf4j
public class UsuariosSERVICE implements UserDetailsService{
    
    @Autowired
    private UsuariosDAO usuarioDao;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        
        Usuarios usuario = usuarioDao.findByUsername(username);
        
        if(usuario == null){
            throw new UsernameNotFoundException(username);
        }
        
        var roles = new ArrayList<GrantedAuthority>();
        
        for(Roles rol: usuario.getRoles()){
            roles.add(new SimpleGrantedAuthority(rol.getNom_roles()));
        }
        
        return new User(usuario.getUsername(), usuario.getClave(), roles);
        
    }
    
}