import { Component } from '@angular/core';
import { EmployeeService } from '../../services/employee.service';
import { EmployeeAddModel } from '../../models/employeeAddModel';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-employee-add',
  templateUrl: './employee-add.component.html',
  styleUrl: './employee-add.component.css'
})
export class EmployeeAddComponent {
  employeeModel: EmployeeAddModel = {
    firstName: '',
    lastName: '',
    departmentId: 0,
    startDate: new Date()
  };

  constructor(private employeeService:EmployeeService,
    private router:Router,
    private toastrService:ToastrService
  ){}

  add(){
    this.employeeService.addEmployee(this.employeeModel).subscribe(() => {
      this.toastrService.success(`${this.employeeModel.firstName} ${this.employeeModel.lastName} eklendi`,"İşlem Başarılı!");
      this.router.navigate(['/employees']);
    },
    () => {
      this.toastrService.error("Employee eklenemedi","Hata!");
    })
  }
}
