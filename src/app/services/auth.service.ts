import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { LoginResponse } from '../models/loginResponse';
import * as jwt_decode from 'jwt-decode';
import { DecodedToken } from '../models/decodedToken';
import { Role } from '../models/role';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  apiUrl = 'http://localhost:8080/api/auth'
  roles: Role[]=[];

  constructor(private httpClient:HttpClient) {
    const token = localStorage.getItem('token');
    if(token){
      const decodedToken= jwt_decode.jwtDecode<DecodedToken>(token);
      this.roles = decodedToken.roles || [];
    }
   }

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

  hasRole(roleName:string):boolean{
    return this.roles.some(role => role.authority === `ROLE_${roleName}`);
  }
}
