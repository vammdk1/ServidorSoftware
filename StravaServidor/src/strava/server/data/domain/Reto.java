package strava.server.data.domain;

import java.io.Serializable;
import java.util.Date;

public class Reto {
	/**
	 * 
	 */
	private String nombre;
	private Date fechaIni;
	private Date fechaFin;
	private float distanciaObj;
	private float tiempoObj;
	private Deportes deporte;
	private float porcentaje;
	
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
		this.porcentaje = 0;
	}
	public float getPorcentaje() {
		return porcentaje;
	}
	public void setPorcentaje(float porcentaje) {
		this.porcentaje = porcentaje;
	}
	public void anadirPorcentaje(float porcentaje) {
		this.porcentaje += porcentaje*100;
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
