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
  username:string=""

  constructor(private httpClient:HttpClient) {
    let token:string | null =""
    if(this.isBrowser())
      token = localStorage.getItem('token');
    if(token){
      const decodedToken= jwt_decode.jwtDecode<DecodedToken>(token);
      this.roles = decodedToken.roles || [];
      this.username = decodedToken.sub || '';
    }
   }

  login(username: string, password: string): Observable<LoginResponse> {
    return this.httpClient.post<LoginResponse>(this.apiUrl + '/login', { username, password });
  }

  saveToken(token: string){
    if(this.isBrowser())
      localStorage.setItem('token', token);
  }

  getToken(){
    if(this.isBrowser())
      return localStorage.getItem('token');
    
    return null;
  }

  logout(){
    if(this.isBrowser())
      localStorage.removeItem('token');
  }

  hasRole(roleName:string):boolean{
    return this.roles.some(role => role.authority === `ROLE_${roleName}`);
  }

  getUsername(){
    return this.username;
  }

  private isBrowser(): boolean {
    return typeof window !== 'undefined' && typeof localStorage !== 'undefined';
  }
}
