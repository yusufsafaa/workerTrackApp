import { Component, OnInit } from '@angular/core';
import { EmployeeDetails } from '../../models/employeeDetails';
import { EmployeeService } from '../../services/employee.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-employee',
  templateUrl: './employee.component.html',
  styleUrl: './employee.component.css'
})
export class EmployeeComponent implements OnInit {
  employeeDetails: EmployeeDetails[] = [];
  selectedEmployeeId: number = 0;
  isModalOpen= false;

  constructor(private employeeService:EmployeeService,
    private route:Router
  ){}
  
  ngOnInit(): void {
    this.getAllEmployeeDetails();
  }

  getAllEmployeeDetails(){
    this.employeeService.getAllEmployeeDetails().subscribe(response => {
      this.employeeDetails = response
    });
  }

  deleteEmployee(id:number) {
    this.employeeService.deleteEmployeeById(id).subscribe(() => {
      console.log(`Employee ${id} silindi`);
    },
    () => {
      console.log(`Employee ${id} silinemedi. HATA!`);
    })
  }

  updateEmployee(id:number) {
    this.route.navigate([`/employees/update/${id}`]);
  }

  openModal(employeeId: number){
    this.isModalOpen = true;
    this.selectedEmployeeId = employeeId;
  }

  closeModal(){
    this.isModalOpen = false;
  }
}
