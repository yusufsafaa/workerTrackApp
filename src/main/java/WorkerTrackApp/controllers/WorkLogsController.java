package WorkerTrackApp.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import WorkerTrackApp.business.abstracts.IWorkLogService;
import WorkerTrackApp.entities.concretes.WorkLog;
import WorkerTrackApp.entities.requests.WorklogAddRequest;
import WorkerTrackApp.entities.requests.WorklogUpdateRequest;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/worklogs")
@AllArgsConstructor
public class WorkLogsController {
	@Autowired
	private IWorkLogService workLogService;
	
	@GetMapping("/getlastsevendays")
	public ResponseEntity<List<WorkLog>> getLast7DaysByEmployeeId(@RequestParam int employeeId){
		List<WorkLog> result = workLogService.getLast7DaysWorkLogsByEmployeeId(employeeId);
		
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	@GetMapping("/getbyid")
	public ResponseEntity<WorkLog> getWorklogById(@RequestParam int id){
		Optional<WorkLog> result = workLogService.getWorkLogById(id);
		
		if(result.isPresent())
			return new ResponseEntity<>(result.get(), HttpStatus.OK);
		
		return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@DeleteMapping()
    public ResponseEntity<String> deleteWorklogById(@RequestParam int id) {
        boolean isRemoved = workLogService.delete(id);

        if (!isRemoved)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        
        return new ResponseEntity<>(HttpStatus.OK);
    }
	
	@PostMapping("/add")
    public ResponseEntity<WorkLog> addWorklog(@RequestBody WorklogAddRequest worklog, @RequestParam int employeeId) {
        try {
            WorkLog savedWorklog = workLogService.add(worklog,employeeId);
            return new ResponseEntity<>(savedWorklog, HttpStatus.CREATED);
        } 
        catch (Exception exc) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
    }
	
	@PostMapping("/update")
    public ResponseEntity<WorkLog> updateWorklog(@RequestBody WorklogUpdateRequest worklogRequest) {
        try {
            WorkLog updatedWorklog = workLogService.update(worklogRequest);
            return new ResponseEntity<>(updatedWorklog, HttpStatus.CREATED);
        } 
        catch (Exception exc) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
