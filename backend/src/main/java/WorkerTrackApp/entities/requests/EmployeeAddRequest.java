package WorkerTrackApp.entities.requests;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeAddRequest {
	private String firstName;
	private String lastName;
	private int departmentId;
	private LocalDate startDate;
}
