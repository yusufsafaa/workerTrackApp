package WorkerTrackApp.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import WorkerTrackApp.business.abstracts.IEmployeeService;
import WorkerTrackApp.entities.DTOs.EmployeeDetailsDTO;
import WorkerTrackApp.entities.DTOs.EmployeeWorkLogsDTO;
import WorkerTrackApp.entities.concretes.Employee;
import WorkerTrackApp.entities.requests.EmployeeAddRequest;
import WorkerTrackApp.entities.requests.EmployeeUpdateRequest;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/employees")
@AllArgsConstructor
public class EmployeesController {
	@Autowired
	private IEmployeeService employeeService;
	
	@PostMapping("/add")
    public ResponseEntity<Employee> addEmployee(@RequestBody EmployeeAddRequest employee) {
        try {
            Employee savedEmployee = employeeService.add(employee);
            return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
        } 
        catch (Exception exc) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
    }
	
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/update")
    public ResponseEntity<Employee> updateEmployee(@RequestBody EmployeeUpdateRequest employeeRequest) {
        try {
            Employee updatedEmployee = employeeService.update(employeeRequest);
            return new ResponseEntity<>(updatedEmployee, HttpStatus.CREATED);
        } 
        catch (Exception exc) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
    }
	
	@GetMapping("/getbyid")
	public ResponseEntity<Employee> getById(@RequestParam int id){
		Optional<Employee> result = employeeService.getEmployeeById(id);
		
		if (result.isPresent()) {
	        return new ResponseEntity<>(result.get(), HttpStatus.OK);
	    } else {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
		
	}
	
	@GetMapping("/getalldetails")
	public ResponseEntity<List<EmployeeDetailsDTO>> getAllEmployeeDetails(){
		List<EmployeeDetailsDTO> result = employeeService.getAllEmployeeDetails();
		
		return new ResponseEntity<>(result,HttpStatus.OK);
		
	}
	
	@GetMapping("/getallworklogs")
	public ResponseEntity<List<EmployeeWorkLogsDTO>> getAllEmployeeWorklogs(@RequestParam int year, @RequestParam int month){
		List<EmployeeWorkLogsDTO> result = employeeService.getAllEmployeeWorklogs(year,month);
		
		return new ResponseEntity<>(result,HttpStatus.OK);
	}
	
	@DeleteMapping()
    public ResponseEntity<String> deleteEmployee(@RequestParam int id) {
        boolean isRemoved = employeeService.deleteEmployeeById(id);

        if (!isRemoved)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
