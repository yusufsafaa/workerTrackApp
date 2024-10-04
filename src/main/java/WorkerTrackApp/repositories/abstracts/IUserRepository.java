package WorkerTrackApp.repositories.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import WorkerTrackApp.entities.concretes.User;

public interface IUserRepository extends JpaRepository<User, Integer>{

}