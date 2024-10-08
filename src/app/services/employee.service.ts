import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { EmployeeDetails } from '../models/employeeDetails';
import { EmployeeModel } from '../models/employeeModel';


@Injectable({
  providedIn: 'root'
})
export class EmployeeService {
  private apiUrl = 'http://localhost:8080/api/employees';

  constructor(private httpClient:HttpClient) { }

  getAllEmployeeDetails():Observable<EmployeeDetails[]>{
    return this.httpClient.get<EmployeeDetails[]>(this.apiUrl + '/getalldetails');
  }

  getEmployeeById(id:number){
    return this.httpClient.get<EmployeeModel>(this.apiUrl+"/getbyid"+"?id="+id);
  }

  deleteEmployeeById(employeeId:number):Observable<any>{
    return this.httpClient.delete<any>(this.apiUrl+ '?id='+employeeId);
  }

  updateEmployee(employee:EmployeeModel){
    return this.httpClient.post(this.apiUrl+"/update", employee);
  }
}
