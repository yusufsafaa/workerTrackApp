package WorkerTrackApp.business.abstracts;

import java.util.List;
import java.util.Optional;

import WorkerTrackApp.entities.concretes.WorkLog;

public interface IWorkLogService {
	Optional<WorkLog> getWorkLogById(int id);
	
	WorkLog add(WorkLog workLog);
	
	WorkLog update(WorkLog workLog);
	
	boolean delete(int id);
	
	List<WorkLog> getLast7DaysWorkLogsByEmployeeId(int employeeId);
}
