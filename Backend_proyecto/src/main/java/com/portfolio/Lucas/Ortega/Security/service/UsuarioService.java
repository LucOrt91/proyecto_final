package com.portfolio.Lucas.Ortega.Security.service;

import java.util.Optional;
import javax.transaction.Transactional;

import com.portfolio.Lucas.Ortega.Security.entity.Usuario;
import com.portfolio.Lucas.Ortega.Security.repository.iUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UsuarioService {
    @Autowired
    iUsuarioRepository iusuarioRepository;

    public Optional<Usuario> getByNombreUsuario(String nombreUsuario){
        return iusuarioRepository.findByNombreUsuario(nombreUsuario);
    }

    public boolean existsByNombreUsuario(String nombreUsuario){
        return iusuarioRepository.existsByNombreUsuario(nombreUsuario);
    }

    public boolean existsByEmail(String email){
        return iusuarioRepository.existsByEmail(email);
    }

    public void save(Usuario usuario){
        iusuarioRepository.save(usuario);
    }
}