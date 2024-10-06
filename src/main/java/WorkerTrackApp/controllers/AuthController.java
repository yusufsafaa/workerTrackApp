package WorkerTrackApp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import WorkerTrackApp.business.abstracts.IUserService;
import WorkerTrackApp.entities.concretes.User;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/register")
public class AuthController {
	@Autowired
    private IUserService userService;

    @PostMapping
    public ResponseEntity<User> register(@RequestBody User user) {
        try {
        	User newUser = userService.register(user);
        	return new ResponseEntity<>(newUser, HttpStatus.CREATED);
		} 
        
        catch (Exception exc) {
        	return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
        
        
    }
}
