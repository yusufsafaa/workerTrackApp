package WorkerTrackApp.business.concrete;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import WorkerTrackApp.business.abstracts.IRoleService;
import WorkerTrackApp.entities.concretes.Role;
import WorkerTrackApp.repositories.abstracts.IRoleRepository;
import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor
public class RoleManager implements IRoleService {
	@Autowired
	private IRoleRepository roleRepository;

	@Override
	public Role add(Role role) {
		return roleRepository.save(role);
	}

	@Override
	public void delete(int id) {
		roleRepository.deleteById(id);
	}
}
