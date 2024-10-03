package WorkerTrackApp.business.abstracts;

import java.util.Optional;

import WorkerTrackApp.entities.concretes.WorkLog;

public interface IWorkLogService {
	Optional<WorkLog> getWorkLogById(int id);
	
	WorkLog create(WorkLog workLog);
	
	WorkLog update(WorkLog workLog);
	
	void delete(int id);
}
