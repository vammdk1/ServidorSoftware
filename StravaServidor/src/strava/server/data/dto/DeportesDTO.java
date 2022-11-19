package strava.server.data.dto;

public enum DeportesDTO {
	CICLISMO(0),
	RUNNING(1);
	
	private int index;
	 
    private DeportesDTO(int index) {
        this.index = index;
    }
 
    public int getIndex() {
        return index;
    }
}
