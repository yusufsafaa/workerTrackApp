package WorkerTrackApp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import WorkerTrackApp.business.abstracts.IAuthService;
import WorkerTrackApp.entities.requests.LoginRequest;
import WorkerTrackApp.entities.requests.RegisterRequest;
import WorkerTrackApp.entities.responses.LoginResponse;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api/auth")
public class AuthController {
	@Autowired
    private IAuthService authService;

    @PostMapping("/register")
    public ResponseEntity<LoginResponse> register(@RequestBody RegisterRequest request) {
        return new ResponseEntity<>(authService.register(request),HttpStatus.OK);
    }
    
    
    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request) {
    	return new ResponseEntity<>(authService.login(request),HttpStatus.OK);
    }
    
    
}
