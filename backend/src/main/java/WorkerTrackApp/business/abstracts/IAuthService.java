package WorkerTrackApp.business.abstracts;

import WorkerTrackApp.entities.requests.LoginRequest;
import WorkerTrackApp.entities.requests.RegisterRequest;
import WorkerTrackApp.entities.responses.LoginResponse;

public interface IAuthService {
	LoginResponse register(RegisterRequest registerRequest);
	
	LoginResponse login(LoginRequest loginRequest);
}
