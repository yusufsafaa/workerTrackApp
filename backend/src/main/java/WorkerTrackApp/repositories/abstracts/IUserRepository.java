package WorkerTrackApp.repositories.abstracts;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import WorkerTrackApp.entities.concretes.User;

@Repository
public interface IUserRepository extends JpaRepository<User, Integer>{
	Optional<User> findByUsername(String username);
}
