import { Component, OnInit } from '@angular/core';
import { WorklogModel } from '../../models/worklogModel';
import { WorklogService } from '../../services/worklog.service';
import { ActivatedRoute, Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';

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
    private router:Router,
    private toastrService:ToastrService
  ){}

  ngOnInit(): void {
    this.employeeId=Number(this.route.snapshot.paramMap.get('employeeId'));
  }

  addWorklog(){
    this.worklogService.addWorklogByEmployeeId(this.worklogModel,this.employeeId).subscribe((response) => {
      this.toastrService.success("İş kaydı oluşturuldu","İşlem Başarılı!");
      this.goToWorklogDetailsBack();
    } ,
    (error) => {
      this.toastrService.error("İş kaydı eklenemedi","Hata!");
    })
  }

  goToWorklogDetailsBack() {
    this.router.navigate([`/worklogs/employee/${this.employeeId}`]);
  }
}
