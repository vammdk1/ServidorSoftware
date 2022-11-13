package strava.data.domain;

import java.util.Date;

public class SesionEntrenamiento {
	private String titulo;
	private String deporte;
	private float distancia;
	private Date fechaHoraIni;
	private float duracion;
	
	/**
	 * Crea una sesion de entrenamiento
	 * @param titulo
	 * @param deporte
	 * @param distancia
	 * @param fechaIni
	 * @param duracion
	 */
	public SesionEntrenamiento(String titulo, String deporte, float distancia, Date fechaIni,
			float duracion) {
		super();
		this.titulo = titulo;
		this.deporte = deporte;
		this.distancia = distancia;
		this.fechaHoraIni = fechaIni;
		this.duracion = duracion;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDeporte() {
		return deporte;
	}

	public void setDeporte(String deporte) {
		this.deporte = deporte;
	}

	public float getDistancia() {
		return distancia;
	}

	public void setDistancia(float distancia) {
		this.distancia = distancia;
	}

	public Date getFechaHoraIni() {
		return fechaHoraIni;
	}

	public void setFechaHoraIni(Date fechaIni) {
		this.fechaHoraIni = fechaIni;
	}


	public float getDuracion() {
		return duracion;
	}

	public void setDuracion(float duracion) {
		this.duracion = duracion;
	}

	@Override
	public String toString() {
		return "SesionEntrenamiento: " + titulo + ". Fecha y hora de inicio: " + fechaHoraIni + " ha durado " + duracion + ". ";
	}
	
	
	
}
