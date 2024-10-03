package WorkerTrackApp.business.abstracts;

import WorkerTrackApp.entities.concretes.Department;

public interface IDepartmentService {
	Department create(Department department);
	
	void delete(int id);
}
