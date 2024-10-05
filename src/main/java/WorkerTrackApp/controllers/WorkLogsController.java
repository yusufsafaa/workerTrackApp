package WorkerTrackApp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import WorkerTrackApp.business.abstracts.IWorkLogService;
import WorkerTrackApp.entities.concretes.WorkLog;
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
}
