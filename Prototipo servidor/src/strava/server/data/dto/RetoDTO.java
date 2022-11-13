package strava.server.data.dto;

import java.util.Date;

public class RetoDTO {
	private String nombre;
	private Date fechaIni;
	private Date fechaFin;
	private float distanciaObjetivo;
	private float tiempoObjetivo;
	private String deporte;
	
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

	public String getDeporte() {
		return deporte;
	}

	public void setDeporte(String deporte) {
		this.deporte = deporte;
	}

	public float getTiempoObjetivo() {
		return tiempoObjetivo;
	}

	public void setTiempoObjetivo(float tiempoObjetivo) {
		this.tiempoObjetivo = tiempoObjetivo;
	}
}
