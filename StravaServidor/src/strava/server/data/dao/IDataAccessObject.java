package strava.server.data.dao;

import java.util.List;

public interface IDataAccessObject<DomainObject> {
	public void save(DomainObject object);
	public void delete(DomainObject object);
	public List<DomainObject> getAll();
	public DomainObject find(String param);
	public DomainObject findFromUser(String user, String param);
}
