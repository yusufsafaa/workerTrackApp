package WorkerTrackApp.entities.requests;

import java.time.LocalTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WorklogUpdateRequest {
	private int id;
	private LocalTime checkInTime;
	private LocalTime chechOutTime;
	private int workDuration;
	private int overTime;
	private int missingTime;
}
