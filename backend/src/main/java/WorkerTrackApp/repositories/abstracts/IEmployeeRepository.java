package WorkerTrackApp.repositories.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import WorkerTrackApp.entities.concretes.Employee;

public interface IEmployeeRepository extends JpaRepository<Employee, Integer> {
	
}
