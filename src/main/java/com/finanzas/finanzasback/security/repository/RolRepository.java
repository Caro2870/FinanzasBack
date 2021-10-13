package com.finanzas.finanzasback.security.repository;

import com.finanzas.finanzasback.security.entity.Rol;
import com.finanzas.finanzasback.security.enums.RolNombre;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RolRepository extends JpaRepository<Rol, Integer> {
    Optional<Rol> findByRolNombre(RolNombre rolNombre);
}
