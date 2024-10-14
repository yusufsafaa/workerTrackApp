import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, Router } from '@angular/router';
import { AuthService } from './auth.service';

@Injectable({
  providedIn: 'root'
})
export class AuthGuard implements CanActivate {
  constructor(private authService: AuthService, 
    private router: Router) {}

  canActivate(route: ActivatedRouteSnapshot):boolean {
    const token = this.authService.getToken();
    
    if(!token){
        this.router.navigate(['/login']);
        return false;
    }

    const expectedRole = route.data['expectedRole'];
    if(expectedRole && !this.authService.hasRole(expectedRole)){
      console.log("Sayfaya erişim izniniz bulunmamaktadır!!");
      this.router.navigate(["/employees"]);
      return false;
    }

    return true;
  }
}
