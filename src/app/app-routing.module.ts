import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { EmployeeComponent } from './components/employee/employee.component';
import { WorklogComponent } from './components/worklog/worklog.component';
import { LoginComponent } from './components/login/login.component';
import { AuthGuard } from './services/auth.guard';
import { EmployeeUpdateComponent } from './components/employee-update/employee-update.component';

const routes: Routes = [
  {path:'login', component:LoginComponent},
  {path:'employees', component:EmployeeComponent, canActivate:[AuthGuard] },
  {path:'employees/update/:id', component:EmployeeUpdateComponent, canActivate:[AuthGuard] },
  {path:'worklogs', component:WorklogComponent, canActivate:[AuthGuard] },
  {path:'', redirectTo:'/login', pathMatch:'full'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
