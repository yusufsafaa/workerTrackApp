import { Component } from '@angular/core';
import { AuthService } from '../../services/auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {
  username: string = '';
  password: string = '';

  constructor(private authService:AuthService,
    private router:Router){}

  login() {
    this.authService.login(this.username, this.password).subscribe((response) => {
        this.authService.saveToken(response.token)
        
        this.router.navigate(['/employees']);
      },
      (error) => {
        console.error('Login failed', error);
      }
    );
  }

}
