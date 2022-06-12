package com.idat.Tarea.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.idat.Tarea.modelo.Bodega;

@Repository
public interface BodegaRepositorio extends JpaRepository<Bodega, Integer> {

}
