package strava.server.data.domain;

import java.io.Serializable;
import java.util.Date;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable(detachable="true")
public class SesionEntrenamiento {
	
	private Deportes deporte;
	

	private String titulo;
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
	public SesionEntrenamiento(String titulo, Deportes deporte, float distancia, Date fechaIni,
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

	public Deportes getDeporte() {
		return deporte;
	}

	public void setDeporte(Deportes deporte) {
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
