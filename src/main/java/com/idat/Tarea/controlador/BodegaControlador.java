package com.idat.Tarea.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.idat.Tarea.dto.BodegaDTORequest;
import com.idat.Tarea.dto.BodegaDTOResponse;
import com.idat.Tarea.servicio.BodegaServicio;

@RestController
@RequestMapping("/bodega/v1")
public class BodegaControlador {

	@Autowired
	private BodegaServicio servicio;

	@RequestMapping(path = "/listar", method = RequestMethod.GET)
	public ResponseEntity<List<BodegaDTOResponse>> listarBodega() {
		return new ResponseEntity<List<BodegaDTOResponse>>(servicio.listarBodegas(), HttpStatus.CREATED);
	}

	@RequestMapping(path = "/guardar", method = RequestMethod.POST)
	public ResponseEntity<Void> guardarBodega(@RequestBody BodegaDTORequest bodega) {
		servicio.guardarBodega(bodega);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}

	@RequestMapping(path = "/listar/{id}")
	public ResponseEntity<BodegaDTOResponse> listarPorId(@PathVariable Integer id) {
		BodegaDTOResponse b = servicio.obtenerBodegaxId(id);
		if (b != null)
			return new ResponseEntity<BodegaDTOResponse>(b, HttpStatus.OK);
		return new ResponseEntity<BodegaDTOResponse>(HttpStatus.NOT_FOUND);
	}

	@RequestMapping(path = "/editar")
	public ResponseEntity<Void> editarBodega(@RequestBody BodegaDTORequest bodega) {
		BodegaDTOResponse b = servicio.obtenerBodegaxId(bodega.getIdBodegaDTO());
		if (b != null) {
			servicio.editarBodega(bodega);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}

	@RequestMapping(path = "/eliminar/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> eliminarBodega(@PathVariable Integer id) {
		BodegaDTOResponse b = servicio.obtenerBodegaxId(id);
		if (b != null) {
			servicio.eliminarBodega(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
}
