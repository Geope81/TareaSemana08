package com.idat.Tarea.servicio;

import java.util.List;

import com.idat.Tarea.dto.BodegaDTORequest;
import com.idat.Tarea.dto.BodegaDTOResponse;

public interface BodegaServicio {
	
	public void guardarBodega(BodegaDTORequest bodega);
	public void editarBodega(BodegaDTORequest bodega);
	public void eliminarBodega(Integer id);
	public List<BodegaDTOResponse> listarBodegas();
	public BodegaDTOResponse obtenerBodegaxId(Integer id);
}
