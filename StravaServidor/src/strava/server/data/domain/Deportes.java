package strava.server.data.domain;

public enum Deportes {
	CICLISMO(0),
	RUNNING(1);
	
	private int index;
	 
    private Deportes(int index) {
        this.index = index;
    }
 
    public int getIndex() {
        return index;
    }
}
