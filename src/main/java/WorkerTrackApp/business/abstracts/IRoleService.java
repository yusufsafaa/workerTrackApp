package WorkerTrackApp.business.abstracts;

import WorkerTrackApp.entities.concretes.Role;

public interface IRoleService {
	Role create(Role role);
	
	void delete(int id);
}
