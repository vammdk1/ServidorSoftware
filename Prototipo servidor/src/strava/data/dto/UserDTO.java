package strava.data.dto;

import java.io.Serializable;
import java.util.Date;

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
	private int frecuenciacardmax;
	private int frecuenciacardreposo;
	
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
	
	public int getFrecuenciacardmax() {
		return frecuenciacardmax;
	}
	
	public void setFrecuenciacardmax(int frecuenciacardmax) {
		this.frecuenciacardmax = frecuenciacardmax;
	}
	
	public int getFrecuenciacardreposo() {
		return frecuenciacardreposo;
	}
	
	public void setFrecuenciacardreposo(int frecuenciacardreposo) {
		this.frecuenciacardreposo = frecuenciacardreposo;
	}
	
	
}
