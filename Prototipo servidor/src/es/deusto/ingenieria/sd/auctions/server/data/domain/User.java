package es.deusto.ingenieria.sd.auctions.server.data.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class User {	
	//fecha nac, peso ,altura, frec car 1 , frec car 2,token token
	private String nombre;
	private String email;
	private Date fechaNac;
	private float peso;
	private int altura;
	private int pulsoxMinuto;
	private int pusoReposo;
	//private "nose" token;
		
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nickname) {
		this.nombre = nombre;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
			
	public Date getFechaNac() {
		return fechaNac;
	}

	public void setFechaNac(Date fechaNac) {
		this.fechaNac = fechaNac;
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

	public int getPusoReposo() {
		return pusoReposo;
	}

	public void setPusoReposo(int pusoReposo) {
		this.pusoReposo = pusoReposo;
	}

	@Override
	public String toString() {
		StringBuffer result = new StringBuffer();
		
		result.append(this.nombre);
		result.append(" - ");
		result.append(this.email);
		
		return result.toString();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this.getClass().getName().equals(obj.getClass().getName())) {
			return this.email.equals(((User)obj).email);
		}
		
		return false;
	}
}