package strava.server.data.dto;

import strava.server.data.domain.User;

public class UserAssembler {
	private static UserAssembler instance;
	
	private UserAssembler() { }
	
	public static UserAssembler getInstance() {
		if (instance == null) {
			instance = new UserAssembler();
		}
		
		return instance;
	}
	
	public UserDTO userToDTO(User user) {
		UserDTO dto = new UserDTO();
		
		dto.setEmail(user.getEmail());
		dto.setNombre(user.getNombre());
		dto.setFechancto(user.getFechaNac());
		dto.setPeso(user.getPeso());
		dto.setAltura(user.getAltura());
		dto.setPulsoxMinuto(user.getPulsoxMinuto());
		dto.setPulsoReposo(user.getPulsoReposo());
		
		return dto;
	}
}
