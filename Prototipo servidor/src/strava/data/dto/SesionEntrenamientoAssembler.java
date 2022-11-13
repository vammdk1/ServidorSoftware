package strava.data.dto;

import strava.data.domain.Reto;
import strava.data.domain.SesionEntrenamiento;

public class SesionEntrenamientoAssembler {
	private static SesionEntrenamientoAssembler instance;
	
	private SesionEntrenamientoAssembler() { }
	
	public static SesionEntrenamientoAssembler getInstance() {
		if (instance == null) {
			instance = new SesionEntrenamientoAssembler();
		}

		return instance;
	}
	
	public SesionEntrenamientoDTO sesionEntrenamientoToDTO(SesionEntrenamiento sesion) {
		SesionEntrenamientoDTO dto = new SesionEntrenamientoDTO();
		
		dto.setTitulo(sesion.getTitulo());
		dto.setDeporte(sesion.getDeporte());
		dto.setDistancia(sesion.getDistancia());
		dto.setFechaHoraInicio(sesion.getFechaHoraIni());
		dto.setDuracion(sesion.getDuracion());
		
		return dto;
	}
}
