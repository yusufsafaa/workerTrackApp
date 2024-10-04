package WorkerTrackApp.business.concrete;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import WorkerTrackApp.business.abstracts.IEmployeeService;
import WorkerTrackApp.entities.concretes.Employee;
import WorkerTrackApp.repositories.abstracts.IEmployeeRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmployeeManager implements IEmployeeService{
	@Autowired
	private IEmployeeRepository employeeRepository;
	
	@Override
	public Optional<Employee> getEmployeeById(int id) {
		return employeeRepository.findById(id);
	}

	@Override
	public Employee add(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public Employee update(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public void delete(int id) {
		employeeRepository.deleteById(id);	
	}

}
