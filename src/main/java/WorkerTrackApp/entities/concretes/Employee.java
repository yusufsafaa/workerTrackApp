package WorkerTrackApp.entities.concretes;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(nullable = false)
	private String firstName;
	
	@Column(nullable = false)
	private String lastName;
	
	@Column(nullable = false)
	private LocalDate startDate;
	
	@ManyToOne
    @JoinColumn(name = "department_id", nullable = false)
	private Department department;
	
	@OneToOne(mappedBy = "employee", cascade = CascadeType.ALL, optional = true)
	private User user;
	
	@OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
	private List<WorkLog> workLogs;
}
