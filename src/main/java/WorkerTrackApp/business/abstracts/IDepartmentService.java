package WorkerTrackApp.business.abstracts;

import WorkerTrackApp.entities.concretes.Department;

public interface IDepartmentService {
	Department add(Department department);
	
	void delete(int id);
}
