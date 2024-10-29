package WorkerTrackApp.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import WorkerTrackApp.business.abstracts.IUserService;
import WorkerTrackApp.entities.concretes.User;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/users")
@AllArgsConstructor
public class UsersController {
	@Autowired
	private IUserService userService;
	
	@GetMapping("/{id}")
	public ResponseEntity<User> getById(@PathVariable int id){
		Optional<User> response = userService.getUserById(id);
		
		if(response.isPresent())
			return new ResponseEntity<>(response.get(),HttpStatus.OK);
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}
