package WorkerTrackApp.business.abstracts;

import java.util.List;
import java.util.Optional;

import WorkerTrackApp.entities.concretes.WorkLog;
import WorkerTrackApp.entities.requests.WorklogAddRequest;

public interface IWorkLogService {
	Optional<WorkLog> getWorkLogById(int id);
	
	WorkLog add(WorklogAddRequest workLog, int employeeId);
	
	WorkLog update(WorkLog workLog);
	
	boolean delete(int id);
	
	List<WorkLog> getLast7DaysWorkLogsByEmployeeId(int employeeId);
}
