package WorkerTrackApp.business.concrete;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import WorkerTrackApp.business.abstracts.IDepartmentService;
import WorkerTrackApp.entities.concretes.Department;
import WorkerTrackApp.repositories.abstracts.IDepartmentRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class DepartmentManager implements IDepartmentService {
	@Autowired
	private IDepartmentRepository departmentRepository;
	
	@Override
	public Department create(Department department) {
		return departmentRepository.save(department);
	}

	@Override
	public void delete(int id) {
		departmentRepository.deleteById(id);
	}
}
