package WorkerTrackApp.entities.concretes;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WorkLog {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(nullable = false)
	private LocalDate workDate;
	
	@Column(nullable = false)
	private LocalTime checkInTime;
	
	@Column(nullable = false)
	private LocalTime chechOutTime;
	
	@Column(nullable = false)
	private Duration workDuration;
	
	@Column(nullable = false)
	private Duration overTime;
	
	@Column(nullable = false)
	private Duration missingTime;
	
	@ManyToOne
    @JoinColumn(name = "employee_id", nullable = false)
	private Employee employee;
}
