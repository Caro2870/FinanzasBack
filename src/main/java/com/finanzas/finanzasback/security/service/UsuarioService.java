package com.finanzas.finanzasback.security.service;

import com.finanzas.finanzasback.exception.ResourceNotFoundException;
import com.finanzas.finanzasback.security.entity.Usuario;
import com.finanzas.finanzasback.security.repository.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
@Service
@Transactional
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    public Usuario getByNombreUsuario(String nombreUsuario){
        return usuarioRepository.findByNombreUsuario(nombreUsuario);
    }

    public Page<Usuario> getAllUsers(Pageable pageable) {
        return usuarioRepository.findAll(pageable);
    }
    public boolean existsByNombreUsuario(String nombreUsuario){
        return usuarioRepository.existsByNombreUsuario(nombreUsuario);
    }

    public boolean existsByDni(String dni){
        return usuarioRepository.existsByDni(dni);
    }
    public boolean existsByRuc(String ruc){
        return usuarioRepository.existsByRuc(ruc);
    }

    public boolean existsByEmail(String email){
        return usuarioRepository.existsByEmail(email);
    }

    public void save(Usuario usuario){
        usuarioRepository.save(usuario);
    }

    public Usuario getUserById(int userId) {
        return  usuarioRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("Usuario", "Id", userId));
    }
}