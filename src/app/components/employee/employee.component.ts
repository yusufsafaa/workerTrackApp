import { Component, OnInit } from '@angular/core';
import { EmployeeDetails } from '../../models/employeeDetails';
import { EmployeeService } from '../../services/employee.service';
import { Router } from '@angular/router';
import { AuthService } from '../../services/auth.service';

@Component({
  selector: 'app-employee',
  templateUrl: './employee.component.html',
  styleUrl: './employee.component.css'
})
export class EmployeeComponent implements OnInit {
  employeeDetails: EmployeeDetails[]=[];
  paginatedEmployees: EmployeeDetails[]=[]

  selectedEmployeeId: number = 0;
  currentPage:number = 1;
  pageSize:number = 10;
  totalPages:number = 0;
  isModalOpen= false;

  constructor(private employeeService:EmployeeService,
    protected authService:AuthService,
    private route:Router
  ){}
  
  ngOnInit(): void {
    this.getAllEmployeeDetails();
  }

  getAllEmployeeDetails(){
    this.employeeService.getAllEmployeeDetails().subscribe(response => {
      this.employeeDetails = response
      this.totalPages= Math.ceil(this.employeeDetails.length / this.pageSize);
      this.updatePaginatedEmployees()
    });
  }

  updatePaginatedEmployees(){
    const startIndex= (this.currentPage - 1) * this.pageSize ;
    const endIndex= startIndex + this.pageSize;
    this.paginatedEmployees= this.employeeDetails.slice(startIndex, endIndex);
  }

  deleteEmployee(id:number) {
    this.employeeService.deleteEmployeeById(id).subscribe(() => {
      console.log(`Employee silindi id:${id}`);
    },
    (error) => {
      console.log(error);
    })
  }

  updateEmployee(id:number) {
    this.route.navigate([`/employees/update/${id}`]);
  }

  goToNextPage(){
    if(this.currentPage < this.totalPages){
      this.currentPage++;
      this.updatePaginatedEmployees();
    }
  }

  goToPreviousPage(){
    if(this.currentPage > 1){
      this.currentPage--;
      this.updatePaginatedEmployees();
    }
  }

  openDeleteModal(employeeId: number){
    this.isModalOpen = true;
    this.selectedEmployeeId = employeeId;
  }

  closeDeleteModal(){
    this.isModalOpen = false;
  }
}
