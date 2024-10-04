package WorkerTrackApp.business.abstracts;

import java.util.Optional;

import WorkerTrackApp.entities.concretes.Employee;
import WorkerTrackApp.entities.concretes.User;

public interface IEmployeeService {
	Optional<Employee> getEmployeeById(int id);
	
	Employee add(Employee employee);
	
	Employee update(Employee employee);
	
	void delete(int id);
}
