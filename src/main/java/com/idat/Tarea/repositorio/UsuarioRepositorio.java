package com.idat.Tarea.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.idat.Tarea.modelo.Usuarios;

@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuarios, Integer> {
	
	Usuarios findByUsuario(String usuario);
	Usuarios findByPassword(String password);
	Usuarios findByCargo(String cargo);
}
