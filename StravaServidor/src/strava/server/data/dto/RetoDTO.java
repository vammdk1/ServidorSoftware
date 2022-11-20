package strava.server.data.dto;

import java.io.Serializable;
import java.util.Date;

import strava.server.data.domain.Deportes;

public class RetoDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nombre;
	private Date fechaIni;
	private Date fechaFin;
	private float distanciaObjetivo;
	private float tiempoObjetivo;
	private DeportesDTO deporte;
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Date getFechaIni() {
		return fechaIni;
	}

	public void setFechaIni(Date fechaIni) {
		this.fechaIni = fechaIni;
	}

	public float getDistanciaObjetivo() {
		return distanciaObjetivo;
	}

	public void setDistanciaObjetivo(float distanciaObjetivo) {
		this.distanciaObjetivo = distanciaObjetivo;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public DeportesDTO getDeporte() {
		return deporte;
	}

	public void setDeporte(DeportesDTO deportes) {
		this.deporte = deportes;
	}

	public float getTiempoObjetivo() {
		return tiempoObjetivo;
	}

	public void setTiempoObjetivo(float tiempoObjetivo) {
		this.tiempoObjetivo = tiempoObjetivo;
	}

	@Override
	public String toString() {
		return nombre;
	}
	
	
}
