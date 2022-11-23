package strava.server.data.dto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
		DeportesDTO[] d = DeportesDTO.values();
		dto.setDeporte(d[reto.getDeporte().getIndex()]);
		
		return dto;
	}
	
	public List<RetoDTO> retoToDTO(List<Reto> retos) {
		List<RetoDTO> dtos = new ArrayList<>();
		
		for (Reto reto : retos) {
			dtos.add(retoToDTO(reto));
		}
		
		return dtos;
	}
	
	public Map<RetoDTO, Float> retoToDTO(Map<Reto, Float> retos) {
		Map<RetoDTO, Float> dtos = new HashMap<>();
		
		for (Reto reto : retos.keySet()) {
			dtos.put(retoToDTO(reto), retos.get(reto));
		}
		
		return dtos;
	}
}
