import { Component, OnInit } from '@angular/core';
import { WorklogService } from '../../services/worklog.service';
import { WorklogModel } from '../../models/worklogModel';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-employee-worklog-update',
  templateUrl: './employee-worklog-update.component.html',
  styleUrl: './employee-worklog-update.component.css'
})
export class EmployeeWorklogUpdateComponent implements OnInit{
  worklogModel:WorklogModel={
    id:0,
    workDate:"",
    checkInTime:"",
    chechOutTime:"",
    workDuration:0,
    overTime:0,
    missingTime:0
  }
  constructor(private worklogService:WorklogService,
    private route:ActivatedRoute){
    this.worklogModel.id = Number(this.route.snapshot.paramMap.get('worklogId'));
  }

  ngOnInit(): void {
    this.getCurrentWorklog();
  }
  
  getCurrentWorklog(){
    this.worklogService.getWorklogById(this.worklogModel.id).subscribe((data) => {
      this.worklogModel=data;
    })
  }

  update(){
    this.worklogService.updateWorklog(this.worklogModel).subscribe(() => {
      console.log(`Worklog id:${this.worklogModel.id} güncellendi`);
    },
     (error) => {
      console.log(error);
    })
  }
}
