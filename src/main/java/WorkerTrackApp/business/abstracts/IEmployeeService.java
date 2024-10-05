package WorkerTrackApp.business.abstracts;

import java.util.List;
import java.util.Optional;

import WorkerTrackApp.entities.DTOs.EmployeeDetailsDTO;
import WorkerTrackApp.entities.DTOs.EmployeeWorkLogsDTO;
import WorkerTrackApp.entities.concretes.Employee;

public interface IEmployeeService {
	Optional<Employee> getEmployeeById(int id);
	
	Employee add(Employee employee);
	
	Employee update(Employee employee);
	
	boolean deleteEmployeeById(int id);
		
	List<EmployeeDetailsDTO> getAllEmployeeDetails();
	
	List<EmployeeWorkLogsDTO> getAllEmployeeWorklogs(int year, int month);
}
