package WorkerTrackApp.repositories.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import WorkerTrackApp.entities.concretes.Role;

public interface IRoleRepository extends JpaRepository<Role, Integer> {
	
	
}
