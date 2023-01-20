package strava.server.data.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class User  {	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//fecha nac, peso ,altura, frec car 1 , frec car 2,token token
	
	@PrimaryKey
	private String nombre;
	private String email;
	private String fechaNac;
	private float peso;
	private int altura;
	private int pulsoxMinuto;
	private int pulsoReposo;
	private Proveedor proveedor;
	//private "nose" token;
	
	
	//private transient ArrayList<Reto> retos = new ArrayList<>();
	private Map<Reto, Float> retos = new HashMap<>();
	private transient ArrayList<SesionEntrenamiento> sesiones = new ArrayList<>();
	
	public User(String nombre,String email,String fechaNac,float peso,int altura,int pulsoxMinuto,int pulsoReposo, Proveedor proveedor) {

		this.nombre=nombre;
		this.email=email;
		this.fechaNac=fechaNac;
		this.peso=peso;
		this.altura=altura;
		this.pulsoxMinuto=pulsoxMinuto;
		this.pulsoReposo=pulsoReposo;
		this.proveedor = proveedor;
	}
		
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nickname) {
		this.nombre = nickname;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
			
	public String getFechaNac() {
		return fechaNac;
	}

	public void setFechaNac(String fechaNac) {
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

	public int getPulsoReposo() {
		return pulsoReposo;
	}

	public void setPulsoReposo(int pulsoReposo) {
		this.pulsoReposo = pulsoReposo;
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
	
	public void anadirReto(Reto r) {
		this.retos.put(r, 0f);
	}
	
	
	public Map<Reto, Float> getRetos() {
		
		return retos;
		
	}
	
	public Map<Reto, Float> getRetosActivos() {
		Map<Reto, Float> retosActivos = new HashMap<>();
		for (Reto r:retos.keySet()) {
			if(new Date().compareTo(r.getFechaFin())<0) {
				retosActivos.put(r, retos.get(r));
			}
		}
		return retosActivos;
		
	}
	
	public void anadirSesion(SesionEntrenamiento s) {
		this.sesiones.add(s);
		for (Reto r : retos.keySet()) {
			if (r.getDeporte()==s.getDeporte()) {
				if (r.getFechaIni().compareTo(s.getFechaHoraIni())<=0) {
					if (r.getFechaFin().compareTo(s.getFechaHoraIni())>=0) {
						if (r.getDistanciaObj()!=0) {
							retos.put(r,anadirPorcentaje(s.getDistancia()/r.getDistanciaObj(), r));
						}else {
							retos.put(r,anadirPorcentaje(s.getDuracion()/r.getTiempoObj(), r));
						}
						if(retos.get(r)>=1) {
							retos.put(r, 1f);
						}
						
					}
				}
			}
			
		}
	}
	
	public float anadirPorcentaje(float i, Reto r) {
		float a = retos.get(r);
		return a + i;
	}
	
	public ArrayList<SesionEntrenamiento> getSesiones() {
		
		return sesiones;
		
	}

	public Proveedor getProveedor() {
		return proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}
}