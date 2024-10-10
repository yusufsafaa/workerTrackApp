package WorkerTrackApp.entities.requests;

import java.time.LocalDate;
import java.time.LocalTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WorklogAddRequest {
	private LocalDate workDate;
	private LocalTime checkInTime;
	private LocalTime chechOutTime;
	private int workDuration;
	private int overTime;
	private int missingTime;
}
