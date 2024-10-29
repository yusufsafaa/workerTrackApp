import { Component } from '@angular/core';
import { EmployeeService } from '../../services/employee.service';
import { EmployeeWorklogsDetails } from '../../models/employeeWorklogsDetails';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-worklog',
  templateUrl: './worklog.component.html',
  styleUrl: './worklog.component.css'
})
export class WorklogComponent {
  selectedYear:number=2024;
  selectedMonth:number=9;
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
    private route:Router,
    private toastrService:ToastrService
  ){}

  getEmployeesWorklogs(){
    this.employeeService.getAllEmployeeWorklogs(this.selectedYear,this.selectedMonth).subscribe(data => {
      this.employeeWorklogs=data;
    },
    () => {
      this.toastrService.error("Hata!")
    })
  }

  getEmployeeWorklogDetails(employeeId:number){
    this.route.navigate([`/worklogs/employee/${employeeId}`]);
  }

  calculateWorkTime(workTime:number){
    const hour = Math.floor(workTime/60)
    const minute = workTime%60

    return (`${hour} saat ${minute} dakika`);
  }

}
