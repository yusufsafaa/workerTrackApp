import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { WorklogModel } from '../models/worklogModel';

@Injectable({
  providedIn: 'root'
})
export class WorklogService {
  private apiUrl = 'http://localhost:8080/api/worklogs';

  constructor(private httpClient:HttpClient) { }

  getWorklogsOfEmployee(employeeId:number):Observable<WorklogModel[]>{
    return this.httpClient.get<WorklogModel[]>(this.apiUrl + `/getlastsevendays?employeeId=${employeeId}`);
  }

  deleteWorklog(id:number){
    return this.httpClient.delete(this.apiUrl+ '?id='+id);
  }

  addWorklogByEmployeeId(worklogModel:WorklogModel,employeeId:number){
    return this.httpClient.post(this.apiUrl+`/add?employeeId=${employeeId}`, worklogModel);
  }

  updateWorklog(worklogModel:WorklogModel){
    return this.httpClient.post(this.apiUrl+"/update", worklogModel);
  }

  getWorklogById(id:number):Observable<WorklogModel>{
    return this.httpClient.get<WorklogModel>(this.apiUrl+`/getbyid?id=${id}`);
  }
}
