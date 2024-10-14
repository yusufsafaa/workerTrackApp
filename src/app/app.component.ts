import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from './services/auth.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'workerTrackAppFrontend';

  constructor(private router:Router,
    protected authService:AuthService
  ) {}

  isLoginPage():boolean {
    return this.router.url === '/login';
  }

  logout(){
    localStorage.removeItem('token');
  }
}
