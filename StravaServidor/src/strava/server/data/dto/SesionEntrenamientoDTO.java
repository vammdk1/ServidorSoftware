package strava.server.data.dto;

import java.io.Serializable;
import java.util.Date;
import strava.server.data.domain.Deportes;

public class SesionEntrenamientoDTO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String titulo;
	private DeportesDTO deporte;
	private float distancia;
	private Date fechaHoraInicio;
	private float duracion;
	
	public String getTitulo() {
		return titulo;
	}
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public DeportesDTO getDeporte() {
		return deporte;
	}

	public void setDeporte(DeportesDTO deporte) {
		this.deporte = deporte;
	}

	public Date getFechaHoraInicio() {
		return fechaHoraInicio;
	}

	public void setFechaHoraInicio(Date fechaHoraInicio) {
		this.fechaHoraInicio = fechaHoraInicio;
	}

	public float getDistancia() {
		return distancia;
	}

	public void setDistancia(float distancia) {
		this.distancia = distancia;
	}

	public float getDuracion() {
		return duracion;
	}

	public void setDuracion(float duracion) {
		this.duracion = duracion;
	}
}
