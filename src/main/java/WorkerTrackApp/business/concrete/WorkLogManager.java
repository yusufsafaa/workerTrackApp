package WorkerTrackApp.business.concrete;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import WorkerTrackApp.business.abstracts.IWorkLogService;
import WorkerTrackApp.entities.concretes.WorkLog;
import WorkerTrackApp.repositories.abstracts.IWorkLogRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class WorkLogManager implements IWorkLogService {
	@Autowired
	private IWorkLogRepository workLogRepository;

	@Override
	public Optional<WorkLog> getWorkLogById(int id) {
		return workLogRepository.findById(id);
	}

	@Override
	public WorkLog add(WorkLog workLog) {
		return workLogRepository.save(workLog);
	}

	@Override
	public WorkLog update(WorkLog workLog) {
		return workLogRepository.save(workLog);
		
	}

	@Override
	public void delete(int id) {
		workLogRepository.deleteById(id);
	}

	@Override
	public List<WorkLog> getLast7DaysWorkLogsByEmployeeId(int employeeId) {
		LocalDate endDate = LocalDate.of(2024, 10, 14); // --> referans tarihi
		LocalDate startDate = endDate.minusDays(7);
		
		return workLogRepository.findByEmployeeIdAndWorkDateBetween(employeeId, startDate, endDate);
		
	}
}
