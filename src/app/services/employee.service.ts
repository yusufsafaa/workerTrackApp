import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { EmployeeDetails } from '../models/employeeDetails';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {
  private apiUrl = 'http://localhost:8080/api/employees';

  constructor(private httpClient:HttpClient) { }

  getAllEmployeeDetails():Observable<EmployeeDetails[]>{
    return this.httpClient.get<EmployeeDetails[]>(this.apiUrl + '/getalldetails');
  }

  deleteEmployeeById(employeeId:number):Observable<any>{
    return this.httpClient.delete<any>(this.apiUrl+ '?id='+employeeId);
  }
}
