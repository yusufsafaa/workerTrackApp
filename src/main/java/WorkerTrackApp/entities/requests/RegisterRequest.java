package WorkerTrackApp.entities.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
	private String firstName;
	private String lastName;
	private String username;
	private String password;
	private int employeeId;
}
