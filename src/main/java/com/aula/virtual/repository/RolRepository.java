package com.aula.virtual.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aula.virtual.domain.Rol;

public interface RolRepository extends JpaRepository<Rol, Long> {

	public Rol findRolByIdRol(int idRol);

}
