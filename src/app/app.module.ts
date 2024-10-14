import { NgModule } from '@angular/core';
import { BrowserModule, provideClientHydration } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

import { RouterModule } from '@angular/router';
import { EmployeeComponent } from './components/employee/employee.component';
import { WorklogComponent } from './components/worklog/worklog.component';
import { HTTP_INTERCEPTORS, HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { LoginComponent } from './components/login/login.component';
import { AuthInterceptorService } from './services/auth-interceptor.service';
import { EmployeeUpdateComponent } from './components/employee-update/employee-update.component';
import { EmployeeAddComponent } from './components/employee-add/employee-add.component';
import { EmployeeWorklogDetailComponent } from './components/employee-worklog-detail/employee-worklog-detail.component';
import { EmployeeWorklogAddComponent } from './components/employee-worklog-add/employee-worklog-add.component';
import { EmployeeWorklogUpdateComponent } from './components/employee-worklog-update/employee-worklog-update.component';

@NgModule({
  declarations: [
    AppComponent,
    EmployeeComponent,
    WorklogComponent,
    LoginComponent,
    EmployeeUpdateComponent,
    EmployeeAddComponent,
    EmployeeWorklogDetailComponent,
    EmployeeWorklogAddComponent,
    EmployeeWorklogUpdateComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    RouterModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [
    provideClientHydration(),
    {
      provide: HTTP_INTERCEPTORS,
      useClass: AuthInterceptorService,
      multi: true
    }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
