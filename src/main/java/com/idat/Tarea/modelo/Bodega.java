package com.idat.Tarea.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "Bodegas")
@Entity
public class Bodega {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idBodega;
	private String nombreBodega;
	private String direccionBodega;
	
	public Integer getIdBodega() {
		return idBodega;
	}
	public void setIdBodega(Integer idBodega) {
		this.idBodega = idBodega;
	}
	public String getNombreBodega() {
		return nombreBodega;
	}
	public void setNombreBodega(String nombreBodega) {
		this.nombreBodega = nombreBodega;
	}
	public String getDireccionBodega() {
		return direccionBodega;
	}
	public void setDireccionBodega(String direccionBodega) {
		this.direccionBodega = direccionBodega;
	}
}
