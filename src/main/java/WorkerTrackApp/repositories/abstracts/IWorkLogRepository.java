package WorkerTrackApp.repositories.abstracts;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import WorkerTrackApp.entities.concretes.WorkLog;

public interface IWorkLogRepository extends JpaRepository<WorkLog, Integer> {
	List<WorkLog> findByEmployeeIdAndWorkDateBetween(int employeeId, LocalDate startDate, LocalDate endDate);
	
}
