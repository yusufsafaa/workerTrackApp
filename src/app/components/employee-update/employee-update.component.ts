import { Component, OnInit } from '@angular/core';
import { EmployeeModel} from '../../models/employeeModel';
import { EmployeeService } from '../../services/employee.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-employee-update',
  templateUrl: './employee-update.component.html',
  styleUrl: './employee-update.component.css'
})
export class EmployeeUpdateComponent implements OnInit {
  employeeModel: EmployeeModel = {
    id: 0,
    firstName: '',
    lastName: '',
    departmentId: 0,
    startDate: new Date()
  };
  
  constructor(private employeeService:EmployeeService,
    private router:Router,
    private route:ActivatedRoute){}
  
  ngOnInit(): void {
    this.getEmployeeById();
    this.employeeModel.id = Number(this.route.snapshot.paramMap.get('id'));
  }

  getEmployeeById(){
    const id = Number(this.route.snapshot.paramMap.get('id'));
    if (id) {
      this.employeeService.getEmployeeById(id).subscribe((data: EmployeeModel) => {
          this.employeeModel = data;
        },
        () => {
          console.error('Çalışan verisi alınırken hata!');
        }
      );
    }
  }

  update(){
    this.employeeService.updateEmployee(this.employeeModel).subscribe(() => {
      this.router.navigate(['/employees']);
    },
    () => {
      console.error('Güncelleme sırasında hata oluştu:');
    })
  }
}
