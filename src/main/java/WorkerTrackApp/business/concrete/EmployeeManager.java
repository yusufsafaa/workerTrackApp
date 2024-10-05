package WorkerTrackApp.business.concrete;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import WorkerTrackApp.business.abstracts.IEmployeeService;
import WorkerTrackApp.entities.DTOs.EmployeeDetailsDTO;
import WorkerTrackApp.entities.DTOs.EmployeeWorkLogsDTO;
import WorkerTrackApp.entities.concretes.Employee;
import WorkerTrackApp.entities.concretes.WorkLog;
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
	public boolean deleteEmployeeById(int id) {
		if(employeeRepository.existsById(id)) {
			employeeRepository.deleteById(id);
			return true;
		}
		
		return false;
	}

	@Override
	public List<EmployeeDetailsDTO> getAllEmployeeDetails() {
		Iterable<Employee> employees = employeeRepository.findAll();
		List<EmployeeDetailsDTO> resultList = new ArrayList<>();
		
		LocalDate referenceDate = LocalDate.of(2024, 10, 14);
		for (Employee employee : employees) {
			EmployeeDetailsDTO dto = new EmployeeDetailsDTO();
			
			Period period = Period.between(employee.getStartDate(), referenceDate);
			String durationText = period.getYears() + " yıl / " + period.getMonths() + " ay / " + period.getDays() + " gün";
			
			dto.setFirstName(employee.getFirstName());
			dto.setLastName(employee.getLastName());
			dto.setDepartmentName(employee.getDepartment().getName());
			dto.setDepartmentPhoneNumber(employee.getDepartment().getPhoneNumber());
			dto.setStartDate(employee.getStartDate());
			dto.setWorkingDuration(durationText);
			
			resultList.add(dto);
		}
		
		return resultList;
	}

	@Override
	public List<EmployeeWorkLogsDTO> getAllEmployeeWorklogs(int year, int month) {
		Iterable<Employee> employees = employeeRepository.findAll();
		List<EmployeeWorkLogsDTO> resultList = new ArrayList<>();
		
		for (Employee employee : employees) {
			List<WorkLog> workLogs = employee.getWorkLogs().stream()
					.filter(workLog -> workLog.getWorkDate().getYear()==year)
					.filter(workLog -> workLog.getWorkDate().getMonthValue()==month)
					.collect(Collectors.toList());
			
			int totalWorkedHours=0;
			int totalMissingHours=0;
			int totalExtraHours=0;
			int totalWorkedDays=0;
			
			
			for (WorkLog wl : workLogs) {
				totalWorkedHours+=wl.getWorkDuration();
				totalMissingHours+=wl.getMissingTime();
				totalExtraHours+=wl.getOverTime();
				totalWorkedDays+=1;
			}
			
			EmployeeWorkLogsDTO dto = new EmployeeWorkLogsDTO();
			
			dto.setId(employee.getId());
			dto.setFirstName(employee.getFirstName());
			dto.setLastName(employee.getLastName());
			dto.setDepartmentName(employee.getDepartment().getName());
			dto.setDepartmentPhoneNumber(employee.getDepartment().getPhoneNumber());
			dto.setTotalExtraMin(totalExtraHours);
			dto.setTotalMissingMin(totalMissingHours);
			dto.setTotalWorkedMin(totalWorkedHours);
			dto.setTotalWorkedDays(totalWorkedDays);
			
			resultList.add(dto);
		}
		
		return resultList;
	}

}
