package WorkerTrackApp.business.abstracts;

import java.util.Optional;

import WorkerTrackApp.entities.concretes.User;

public interface IUserService {
	Optional<User> getUserById(int id);
	
	User create(User user);
	
	User update(User user);
	
	void delete(int id);
}
