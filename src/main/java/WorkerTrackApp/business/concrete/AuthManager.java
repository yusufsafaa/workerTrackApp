package WorkerTrackApp.business.concrete;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import WorkerTrackApp.business.abstracts.IAuthService;
import WorkerTrackApp.business.abstracts.IEmployeeService;
import WorkerTrackApp.core.config.JwtService;
import WorkerTrackApp.entities.concretes.Employee;
import WorkerTrackApp.entities.concretes.User;
import WorkerTrackApp.entities.requests.LoginRequest;
import WorkerTrackApp.entities.requests.RegisterRequest;
import WorkerTrackApp.entities.responses.LoginResponse;
import WorkerTrackApp.repositories.abstracts.IUserRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AuthManager implements IAuthService {
	@Autowired
	private IUserRepository userRepository;
	@Autowired
	private IEmployeeService employeeService;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private JwtService jwtService;
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Override
	public LoginResponse register(RegisterRequest request) {
		User user = new User();
		
		user.setFirstName(request.getFirstName());
		user.setLastName(request.getLastName());
		user.setUsername(request.getUsername());
		user.setPassword(passwordEncoder.encode(request.getPassword()));
		
		user.setEmployee(employeeService.getEmployeeById(request.getEmployeeId()).get());
		
		userRepository.save(user);
		String jwtToken = jwtService.generateToken(user);
		
		return new LoginResponse(jwtToken);
	}

	@Override
	public LoginResponse login(LoginRequest request) {
		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
		
		User user = userRepository.findByUsername(request.getUsername()).orElseThrow();
		String jwtToken = jwtService.generateToken(user);
		
		return new LoginResponse(jwtToken);
	}

}
