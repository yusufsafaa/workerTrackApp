import { Component } from '@angular/core';
import { EmployeeService } from '../../services/employee.service';
import { EmployeeAddModel } from '../../models/employeeAddModel';
import { Router } from '@angular/router';

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
    private router:Router
  ){}

  add(){
    this.employeeService.addEmployee(this.employeeModel).subscribe(() => {
      this.router.navigate(['/employees']);
    },
    () => {
      console.error('Ekleme sırasında hata oluştu:');
    })
  }
}
