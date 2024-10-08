import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { LoginResponse } from '../models/loginResponse';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  apiUrl = 'http://localhost:8080/api/auth'

  constructor(private httpClient:HttpClient) { }

  login(username: string, password: string): Observable<LoginResponse> {
    return this.httpClient.post<LoginResponse>(this.apiUrl + '/login', { username, password });
  }

  saveToken(token: string){
    localStorage.setItem('token', token);
  }

  getToken(){
    return localStorage.getItem('token');
  }

  logout(){
    localStorage.removeItem('token');
  }
}
