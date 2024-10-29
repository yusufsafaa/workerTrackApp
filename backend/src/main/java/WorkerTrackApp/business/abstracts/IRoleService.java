package WorkerTrackApp.business.abstracts;

import WorkerTrackApp.entities.concretes.Role;

public interface IRoleService {
	Role add(Role role);
	
	void delete(int id);
}
