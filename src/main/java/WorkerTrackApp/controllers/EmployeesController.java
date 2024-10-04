package WorkerTrackApp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import WorkerTrackApp.business.abstracts.IEmployeeService;
import WorkerTrackApp.entities.DTOs.EmployeeDetailsDTO;
import WorkerTrackApp.entities.concretes.Employee;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/employees")
@AllArgsConstructor
public class EmployeesController {
	@Autowired
	private IEmployeeService employeeService;
	
	@PostMapping("/add")
    public ResponseEntity<Employee> addUser(@RequestBody Employee employee) {
        try {
            Employee savedEmployee = employeeService.add(employee);
            return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
	
	@GetMapping("/getalldetails")
	public ResponseEntity<List<EmployeeDetailsDTO>> getAllEmployee(){
		List<EmployeeDetailsDTO> result = employeeService.getAllEmployeeDetails();
		
		return new ResponseEntity<>(result,HttpStatus.OK);
	}
}
