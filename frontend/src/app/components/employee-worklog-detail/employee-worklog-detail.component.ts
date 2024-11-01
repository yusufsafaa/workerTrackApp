import { Component, OnInit } from '@angular/core';
import { WorklogModel } from '../../models/worklogModel';
import { WorklogService } from '../../services/worklog.service';
import { ActivatedRoute, Router } from '@angular/router';
import { AuthService } from '../../services/auth.service';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-employee-worklog-detail',
  templateUrl: './employee-worklog-detail.component.html',
  styleUrl: './employee-worklog-detail.component.css'
})
export class EmployeeWorklogDetailComponent implements OnInit{
  worklogs:WorklogModel[]=[];
  employeeId:number=0;
  isModalOpen= false;
  selectedWorklogId:number=0;

  constructor(private worklogService:WorklogService,
    protected authService:AuthService,
    private route:ActivatedRoute,
    private router:Router,
    private toastrService:ToastrService
  ){}

  ngOnInit(): void {
    this.employeeId=Number(this.route.snapshot.paramMap.get('employeeId'));
    this.getEmployeeWorklogs()
  }

  getEmployeeWorklogs(){
    this.worklogService.getWorklogsOfEmployee(this.employeeId).subscribe(data => {
      this.worklogs=data;
    },
  () => {
    console.log("HATA!");
  })
  }

  deleteWorklog(id:number){
    this.worklogService.deleteWorklog(id).subscribe(() => {
      this.toastrService.warning(`Id: ${id} numaralı iş kaydı silindi`,"İşlem Başarılı!")
    },
    (error) => {
      this.toastrService.error(`İş kaydı silinemedi. Id:${id}`,"Hata!")
    })
  }

  updateWorklog(worklogId:number) {
    this.router.navigate([`/worklogs/employee/${worklogId}/update`]);
  }

  openModal(employeeId: number){
    this.isModalOpen = true;
    this.selectedWorklogId = employeeId;
  }

  closeModal(){
    this.isModalOpen = false;
  }
}
