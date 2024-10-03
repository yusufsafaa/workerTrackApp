package WorkerTrackApp.repositories.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import WorkerTrackApp.entities.concretes.WorkLog;

public interface IWorkLogRepository extends JpaRepository<WorkLog, Integer> {

}
