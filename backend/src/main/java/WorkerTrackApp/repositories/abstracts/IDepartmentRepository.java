package WorkerTrackApp.repositories.abstracts;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import WorkerTrackApp.entities.concretes.Department;

public interface IDepartmentRepository extends JpaRepository<Department, Integer>{
	Optional<Department> findById(int id);
}
