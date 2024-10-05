package WorkerTrackApp.entities.DTOs;

import WorkerTrackApp.entities.enums.DepartmentName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeWorkLogsDTO {
	private int id;
	private String firstName;
	private String lastName;
	private DepartmentName departmentName;
	private String departmentPhoneNumber;
	private int totalWorkedDays;
	private int totalWorkedMin;
	private int totalMissingMin;
	private int totalExtraMin;
}
