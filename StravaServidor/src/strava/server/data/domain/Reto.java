package strava.server.data.domain;

import java.util.Date;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;

@PersistenceCapable(detachable="true")
public class Reto {
	/**
	 * 
	 */
	@Persistent
	private String nombre = null;
	@Persistent
	private Date fechaIni = null;
	@Persistent
	private Date fechaFin = null;
	@Persistent
	private float distanciaObj = 0;
	@Persistent
	private float tiempoObj = 0;
	@Persistent
	private Deportes deporte = null;
	/**
	 * 
	 * @param nombre
	 * @param fechaIni
	 * @param fechaFin
	 * @param distanciaObj
	 * @param tiempoObj esto está pensado en horas
	 * @param deporte
	 */
	
	public Reto(String nombre, Date fechaIni, Date fechaFin, float distanciaObj, float tiempoObj, Deportes deporte) {
		super();
		this.nombre = nombre;
		this.fechaIni = fechaIni;
		this.fechaFin = fechaFin;
		this.distanciaObj = distanciaObj;
		this.tiempoObj = tiempoObj;
		this.deporte = deporte;
	}
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
	public Date getFechaFin() {
		return fechaFin;
	}
	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}
	public float getDistanciaObj() {
		return distanciaObj;
	}
	public void setDistanciaObj(float distanciaObj) {
		this.distanciaObj = distanciaObj;
	}
	public float getTiempoObj() {
		return tiempoObj;
	}
	public void setTiempoObj(float tiempoObj) {
		this.tiempoObj = tiempoObj;
	}
	public Deportes getDeporte() {
		return deporte;
	}
	public void setDeporte(Deportes deporte) {
		this.deporte = deporte;
	}
	@Override
	public String toString() {
		return "Reto [nombre=" + nombre + ", fechaIni=" + fechaIni + ", fechaFin=" + fechaFin + ", distanciaObj="
				+ distanciaObj + ", tiempoObj=" + tiempoObj + ", deporte=" + deporte + "]";
	}
	
	
	
}
