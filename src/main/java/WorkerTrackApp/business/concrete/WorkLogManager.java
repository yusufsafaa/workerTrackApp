package WorkerTrackApp.business.concrete;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import WorkerTrackApp.business.abstracts.IWorkLogService;
import WorkerTrackApp.entities.concretes.Employee;
import WorkerTrackApp.entities.concretes.WorkLog;
import WorkerTrackApp.entities.requests.WorklogAddRequest;
import WorkerTrackApp.repositories.abstracts.IEmployeeRepository;
import WorkerTrackApp.repositories.abstracts.IWorkLogRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class WorkLogManager implements IWorkLogService {
	@Autowired
	private IWorkLogRepository workLogRepository;
	@Autowired 
	private IEmployeeRepository employeeRepository;

	@Override
	public Optional<WorkLog> getWorkLogById(int id) {
		return workLogRepository.findById(id);
	}

	@Override
	public WorkLog add(WorklogAddRequest request, int employeeId) {
		WorkLog workLog= new WorkLog();
		workLog.setWorkDate(request.getWorkDate());
		workLog.setCheckInTime(request.getCheckInTime());
		workLog.setChechOutTime(request.getChechOutTime());
		workLog.setWorkDuration(request.getWorkDuration());
		workLog.setOverTime(request.getOverTime());
		workLog.setMissingTime(request.getMissingTime());
		
		Optional<Employee> emp = employeeRepository.findById(employeeId);
		
		if(emp.isPresent()) {
			workLog.setEmployee(emp.get());
		}
		
		return workLogRepository.save(workLog);
	}

	@Override
	public WorkLog update(WorkLog workLog) {
		return workLogRepository.save(workLog);
		
	}

	@Override
	public boolean delete(int id) {
		if(workLogRepository.existsById(id)) {
			workLogRepository.deleteById(id);
			return true;
		}
		
		return false;
	}

	@Override
	public List<WorkLog> getLast7DaysWorkLogsByEmployeeId(int employeeId) {
		LocalDate endDate = LocalDate.of(2024, 10, 14); // --> referans tarihi
		LocalDate startDate = endDate.minusDays(7);
		
		return workLogRepository.findByEmployeeIdAndWorkDateBetween(employeeId, startDate, endDate);
		
	}
}
