package strava.server.data.dto;

import java.util.ArrayList;
import java.util.List;

import strava.server.data.domain.Deportes;
import strava.server.data.domain.Reto;
import strava.server.data.domain.SesionEntrenamiento;

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
		DeportesDTO[] d = DeportesDTO.values();
		dto.setDeporte(d[sesion.getDeporte().getIndex()]);
		dto.setDistancia(sesion.getDistancia());
		dto.setFechaHoraInicio(sesion.getFechaHoraIni());
		dto.setDuracion(sesion.getDuracion());
		
		return dto;
	}

	public List<SesionEntrenamientoDTO> sesionEntrenamientoToDTO(List<SesionEntrenamiento> sesiones) {
		List<SesionEntrenamientoDTO> dtos = new ArrayList<>();
		
		for (SesionEntrenamiento sesion : sesiones) {
			dtos.add(sesionEntrenamientoToDTO(sesion));
		}
		
		return dtos;
	}
}
