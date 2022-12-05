package strava.server.gateway;

import strava.server.data.domain.Proveedor;

public interface IServerGateway {
	public boolean iniciarSesion(String email, String password);
}
