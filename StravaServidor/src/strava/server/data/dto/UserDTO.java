package strava.server.data.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

import strava.server.data.domain.Proveedor;
import strava.server.data.domain.Reto;
import strava.server.data.domain.SesionEntrenamiento;

public class UserDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nombre;
	private String email;
	private String fechancto;
	private  float peso;
	private int altura;
	private int pulsoxMinuto;
	private int pulsoReposo;
	private ProveedorDTO proveedor;
		
	private ArrayList<Reto> retos = new ArrayList<>();
	private ArrayList<SesionEntrenamiento> sesiones = new ArrayList<>();
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getFechancto() {
		return fechancto;
	}
	public void setFechancto(String string) {
		this.fechancto = string;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public float getPeso() {
		return peso;
	}
	
	public void setPeso(float peso) {
		this.peso = peso;
	}
	
	public int getAltura() {
		return altura;
	}
	
	public void setAltura(int altura) {
		this.altura = altura;
	}
	
	public int getPulsoxMinuto() {
		return pulsoxMinuto;
	}

	public void setPulsoxMinuto(int pulsoxMinuto) {
		this.pulsoxMinuto = pulsoxMinuto;
	}

	public int getPulsoReposo() {
		return pulsoReposo;
	}

	public void setPulsoReposo(int pulsoReposo) {
		this.pulsoReposo = pulsoReposo;
	}

	public ProveedorDTO getProveedor() {
		return proveedor;
	}

	public void setProveedor(ProveedorDTO proveedor) {
		this.proveedor = proveedor;
	}

	public void anadirReto(Reto r) {
		this.retos.add(r);
	}
	
	
	public ArrayList<Reto> getRetos() {
		
		return retos;
		
	}
	
	public ArrayList<Reto> getRetosActivos() {
		ArrayList<Reto> retosActivos = new ArrayList<>();
		for (Reto r:retos) {
			if(new Date().compareTo(r.getFechaFin())<0) {
				retosActivos.add(r);
			}
		}
		return retosActivos;
		
	}
	
	public void anadirSesion(SesionEntrenamiento s) {
		this.sesiones.add(s);
	}
	
	public ArrayList<SesionEntrenamiento> getSesiones() {
		
		return sesiones;
		
	}
	
}
