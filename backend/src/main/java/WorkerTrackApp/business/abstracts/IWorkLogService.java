package WorkerTrackApp.business.abstracts;

import java.util.List;
import java.util.Optional;

import WorkerTrackApp.entities.concretes.WorkLog;
import WorkerTrackApp.entities.requests.WorklogAddRequest;
import WorkerTrackApp.entities.requests.WorklogUpdateRequest;

public interface IWorkLogService {
	Optional<WorkLog> getWorkLogById(int id);
	
	WorkLog add(WorklogAddRequest workLog, int employeeId);
	
	WorkLog update(WorklogUpdateRequest request);
	
	boolean delete(int id);
	
	List<WorkLog> getLast7DaysWorkLogsByEmployeeId(int employeeId);
}
