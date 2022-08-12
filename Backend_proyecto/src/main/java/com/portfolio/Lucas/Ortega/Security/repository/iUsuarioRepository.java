package com.portfolio.Lucas.Ortega.Security.repository;

import java.util.Optional;

import com.portfolio.Lucas.Ortega.Security.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface iUsuarioRepository extends JpaRepository<Usuario, Integer>{
    Optional<Usuario> findByNombreUsuario(String nombreUsuario);

    boolean existsByNombreUsuario(String nombreUsuario);
    boolean existsByEmail(String email);
}