import { Component } from '@angular/core';
import { EmployeeService } from '../../services/employee.service';
import { EmployeeWorklogsDetails } from '../../models/employeeWorklogsDetails';
import { Router } from '@angular/router';

@Component({
  selector: 'app-worklog',
  templateUrl: './worklog.component.html',
  styleUrl: './worklog.component.css'
})
export class WorklogComponent {
  selectedYear:number=0;
  selectedMonth:number=0;
  employeeWorklogs:EmployeeWorklogsDetails[]=[];
  
  months = [
    {name:'Ocak', value:1},
    {name:'Şubat', value:2},
    {name:'Mart', value:3},
    {name:'Nisan', value:4},
    {name:'Mayıs', value:5},
    {name:'Haziran', value:6},
    {name:'Temmuz', value:7},
    {name:'Ağustos', value:8},
    {name:'Eylül', value:9},
    {name:'Ekim', value:10},
    {name:'Kasım', value:11},
    {name:'Aralık', value:12}
  ];

  constructor(private employeeService:EmployeeService,
    private route:Router
  ){}

  getEmployeesWorklogs(){
    this.employeeService.getAllEmployeeWorklogs(this.selectedYear,this.selectedMonth).subscribe(data => {
      this.employeeWorklogs=data;
    },
    () => {
      console.log("HATA!");
    })
  }

  getEmployeeWorklogDetails(employeeId:number){
    this.route.navigate([`/worklogs/employee/${employeeId}`]);
  }

}
