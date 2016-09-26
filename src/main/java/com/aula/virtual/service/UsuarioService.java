package com.aula.virtual.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aula.virtual.domain.Usuario;
import com.aula.virtual.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	UsuarioRepository usuarioRepository;

	public Usuario findUsuarioByIdUsuario(int idUsuario) {
		return usuarioRepository.findUsuarioByIdUsuario(idUsuario);
	}

	public List<Usuario> findAll() {
		return usuarioRepository.findAll();
	}

}
