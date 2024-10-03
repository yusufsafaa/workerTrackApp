package WorkerTrackApp.business.concrete;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import WorkerTrackApp.business.abstracts.IUserService;
import WorkerTrackApp.entities.concretes.User;
import WorkerTrackApp.repositories.abstracts.IUserRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserManager implements IUserService{
	@Autowired
	private IUserRepository userRepository;
	
	@Override
	public Optional<User> getUserById(int id) {
		return userRepository.findById(id);
	}

	@Override
	public User create(User user) {
		return userRepository.save(user);
	}

	@Override
	public User update(User user) {
		return userRepository.save(user);
	}

	@Override
	public void delete(int id) {
		userRepository.deleteById(id);
	}

}
