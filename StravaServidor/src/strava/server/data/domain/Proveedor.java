package strava.server.data.domain;

public enum Proveedor {
	GOOGLE(0),
	FACEBOOK(1),
	LOCAL(2);
	
	private int index;
	 
    private Proveedor(int index) {
        this.index = index;
    }
 
    public int getIndex() {
        return index;
    }
}
