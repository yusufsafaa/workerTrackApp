package WorkerTrackApp.business.concrete;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import WorkerTrackApp.entities.concretes.User;
import WorkerTrackApp.repositories.abstracts.IUserRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CustomUserDetailsManager implements UserDetailsService{
	
	@Autowired
	private IUserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> currentUser = userRepository.findByUsername(username);
		
		if(currentUser.isPresent()) {
			return org.springframework.security.core.userdetails.User
					.withUsername(username)
					.password(currentUser.get().getPassword())
					.authorities(currentUser.get().getRoles().stream().map(role -> new SimpleGrantedAuthority(role.getName().toString())).collect(Collectors.toList()))
		            .build();
		}
		
		throw new UsernameNotFoundException("No user found: " + username);
		
	}

}
