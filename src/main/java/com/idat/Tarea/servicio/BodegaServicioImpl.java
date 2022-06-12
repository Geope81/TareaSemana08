package com.idat.Tarea.servicio;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.Tarea.dto.BodegaDTORequest;
import com.idat.Tarea.dto.BodegaDTOResponse;
import com.idat.Tarea.modelo.Bodega;
import com.idat.Tarea.repositorio.BodegaRepositorio;

@Service 
public class BodegaServicioImpl implements BodegaServicio{
	
	@Autowired
	public BodegaRepositorio repositorio;	

	@Override
	public void guardarBodega(BodegaDTORequest bodega) {
		Bodega b = new Bodega();
		b.setIdBodega(bodega.getIdBodegaDTO());
		b.setNombreBodega(bodega.getNombreBodegaDTO());
		b.setDireccionBodega(bodega.getDireccionBodegaDTO());
		repositorio.save(b);		
	}
	

	@Override
	public void editarBodega(BodegaDTORequest bodega) {
		Bodega b = new Bodega();
		b.setIdBodega(bodega.getIdBodegaDTO());
		b.setNombreBodega(bodega.getNombreBodegaDTO());
		b.setDireccionBodega(bodega.getDireccionBodegaDTO());
		repositorio.saveAndFlush(b);		
	}
	

	@Override
	public void eliminarBodega(Integer id) {
		repositorio.deleteById(id);		
	}
	

	@Override
	public List<BodegaDTOResponse> listarBodegas() {
		List<BodegaDTOResponse> lista = new ArrayList<BodegaDTOResponse>();
		BodegaDTOResponse b = null; 
		
		for (Bodega bodega : repositorio.findAll()) {
			b = new BodegaDTOResponse();
			b.setIdBodegaDTO(bodega.getIdBodega());
			b.setNombreBodegaDTO(bodega.getNombreBodega());
			b.setDireccionBodegaDTO(bodega.getDireccionBodega());
			lista.add(b);			
		}		
		return lista;
	}

	@Override
	public BodegaDTOResponse obtenerBodegaxId(Integer id) {
		Bodega bodega = repositorio.findById(id).orElse(null);
		
		BodegaDTOResponse b = new BodegaDTOResponse();
		b.setIdBodegaDTO(bodega.getIdBodega());
		b.setNombreBodegaDTO(bodega.getNombreBodega());
		b.setDireccionBodegaDTO(bodega.getDireccionBodega());		
		return b;
	}
}
