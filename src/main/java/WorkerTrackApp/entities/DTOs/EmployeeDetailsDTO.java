package WorkerTrackApp.entities.DTOs;

import java.time.LocalDate;

import WorkerTrackApp.entities.enums.DepartmentName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDetailsDTO {
	private int id;
	private String firstName;
	private String lastName;
	private DepartmentName departmentName;
	private String departmentPhoneNumber;
	private LocalDate startDate;
	private String workingDuration;
}
