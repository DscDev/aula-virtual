package com.aula.virtual.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aula.virtual.domain.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	public Usuario findUsuarioByIdUsuario(int idUsuario);

	public Usuario findUsuarioByUsuarioAndPassword(String usuario, String password);

}
