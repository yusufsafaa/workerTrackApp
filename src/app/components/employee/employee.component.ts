import { Component, OnInit } from '@angular/core';
import { EmployeeDetails } from '../../models/employeeDetails';
import { EmployeeService } from '../../services/employee.service';

@Component({
  selector: 'app-employee',
  templateUrl: './employee.component.html',
  styleUrl: './employee.component.css'
})
export class EmployeeComponent implements OnInit {
  employeeDetails: EmployeeDetails[] = [];
  selectedEmployeeId: number = 0;
  isModalOpen= false;

  constructor(private employeeService:EmployeeService){}
  
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

  editEmployee() {
    throw new Error('Method not implemented.');
  }

  openModal(employeeId: number){
    this.isModalOpen = true;
    this.selectedEmployeeId = employeeId;
  }

  closeModal(){
    this.isModalOpen = false;
  }
}
