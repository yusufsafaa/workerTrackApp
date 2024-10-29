import { Component } from '@angular/core';
import { AuthService } from '../../services/auth.service';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {
  username: string = '';
  password: string = '';

  constructor(private authService:AuthService,
    private router:Router,
    private toastrService:ToastrService){}

  login() {
    this.authService.login(this.username, this.password).subscribe((response) => {
        this.authService.saveToken(response.token)
        this.toastrService.info(`Kullanıcı Adı: ${this.username}`,"Hoşgeldiniz!")
        this.router.navigate(['/employees']);
      },
      (error) => {
        this.toastrService.error("Kullanıcı adı veya parolanız hatalı!","Hatalı Giriş!")
      }
    );
  }

}
