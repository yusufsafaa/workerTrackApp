import { Component, OnInit } from '@angular/core';
import { WorklogModel } from '../../models/worklogModel';
import { WorklogService } from '../../services/worklog.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-employee-worklog-add',
  templateUrl: './employee-worklog-add.component.html',
  styleUrl: './employee-worklog-add.component.css'
})
export class EmployeeWorklogAddComponent implements OnInit{
  worklogModel: WorklogModel = {} as WorklogModel;
  employeeId:number=0;

  constructor(private worklogService:WorklogService,
    private route:ActivatedRoute,
    private router:Router
  ){}

  ngOnInit(): void {
    this.employeeId=Number(this.route.snapshot.paramMap.get('employeeId'));
  }

  addWorklog(){
    this.worklogService.addWorklogByEmployeeId(this.worklogModel,this.employeeId).subscribe((response) => {
      console.log(response);
      this.goToWorklogDetailsBack();
    },
    (error) => {
      console.log(error);
    })
  }

  goToWorklogDetailsBack() {
    this.router.navigate([`/worklogs/employee/${this.employeeId}`]);
  }
}
