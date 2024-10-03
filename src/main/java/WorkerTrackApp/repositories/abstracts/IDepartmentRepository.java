package WorkerTrackApp.repositories.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import WorkerTrackApp.entities.concretes.Department;

public interface IDepartmentRepository extends JpaRepository<Department, Integer>{

}
