package strava.server.data.dto;

import strava.server.data.domain.Reto;

public class RetoAssembler {
	private static RetoAssembler instance;
	
	private RetoAssembler() { }
	
	public static RetoAssembler getInstance() {
		if (instance == null) {
			instance = new RetoAssembler();
		}

		return instance;
	}
	
	public RetoDTO retoToDTO(Reto reto) {
		RetoDTO dto = new RetoDTO();
		
		dto.setNombre(reto.getNombre());
		dto.setFechaIni(reto.getFechaIni());
		dto.setFechaFin(reto.getFechaFin());
		dto.setDistanciaObjetivo(reto.getDistanciaObj());
		dto.setTiempoObjetivo(reto.getTiempoObj());
		dto.setDeporte(reto.getDeporte());
		
		return dto;
	}
}
