package com.finanzas.finanzasback.security.repository;

import com.finanzas.finanzasback.security.entity.Usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    Usuario findByNombreUsuario(String nombre);

    boolean existsByNombreUsuario(String nombreUsuario);
    boolean existsByEmail(String email);
    boolean existsByDni(String dni);
    boolean existsByRuc(String ruc);


}
