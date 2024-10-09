package WorkerTrackApp.business.abstracts;

import java.util.List;
import java.util.Optional;

import WorkerTrackApp.entities.DTOs.EmployeeDetailsDTO;
import WorkerTrackApp.entities.DTOs.EmployeeWorkLogsDTO;
import WorkerTrackApp.entities.concretes.Employee;
import WorkerTrackApp.entities.requests.EmployeeAddRequest;
import WorkerTrackApp.entities.requests.EmployeeUpdateRequest;

public interface IEmployeeService {
	Optional<Employee> getEmployeeById(int id);
	
	Employee add(EmployeeAddRequest employee);
	
	Employee update(EmployeeUpdateRequest employeeRequest);
	
	boolean deleteEmployeeById(int id);
		
	List<EmployeeDetailsDTO> getAllEmployeeDetails();
	
	List<EmployeeWorkLogsDTO> getAllEmployeeWorklogs(int year, int month);
}
