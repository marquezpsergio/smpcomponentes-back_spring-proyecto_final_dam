package com.smpcomponentes.security.services;

import com.smpcomponentes.models.entity.Usuario;
import com.smpcomponentes.models.services.IUsuarioService;
import com.smpcomponentes.security.UsuarioPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    IUsuarioService usuarioService;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String user) throws UsernameNotFoundException {
        Usuario usuario = usuarioService.findByNombreUsuario(user);
        return UsuarioPrincipal.build(usuario);
    }
}
