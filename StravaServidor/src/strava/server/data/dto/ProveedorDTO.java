package strava.server.data.dto;

public enum ProveedorDTO {
	GOOGLE(0),
	FACEBOOK(1),
	LOCAL(2);
	
	private int index;
	 
    private ProveedorDTO(int index) {
        this.index = index;
    }
 
    public int getIndex() {
        return index;
    }
}
