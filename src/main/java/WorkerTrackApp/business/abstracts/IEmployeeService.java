package WorkerTrackApp.business.abstracts;

import java.util.List;
import java.util.Optional;

import WorkerTrackApp.entities.DTOs.EmployeeDetailsDTO;
import WorkerTrackApp.entities.concretes.Employee;

public interface IEmployeeService {
	Optional<Employee> getEmployeeById(int id);
	
	Employee add(Employee employee);
	
	Employee update(Employee employee);
	
	void delete(int id);
	
	List<Employee> getAllEmployee();
	
	List<EmployeeDetailsDTO> getAllEmployeeDetails();
}
