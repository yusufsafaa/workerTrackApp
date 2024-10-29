import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { EmployeeComponent } from './components/employee/employee.component';
import { WorklogComponent } from './components/worklog/worklog.component';
import { LoginComponent } from './components/login/login.component';
import { AuthGuard } from './services/auth.guard';
import { EmployeeUpdateComponent } from './components/employee-update/employee-update.component';
import { EmployeeAddComponent } from './components/employee-add/employee-add.component';
import { EmployeeWorklogDetailComponent } from './components/employee-worklog-detail/employee-worklog-detail.component';
import { EmployeeWorklogAddComponent } from './components/employee-worklog-add/employee-worklog-add.component';
import { EmployeeWorklogUpdateComponent } from './components/employee-worklog-update/employee-worklog-update.component';

const routes: Routes = [
  {path:'login', component:LoginComponent},
  {path:'employees', component:EmployeeComponent, canActivate:[AuthGuard]},
  {path:'employees/update/:id', component:EmployeeUpdateComponent, canActivate:[AuthGuard], data:{expectedRole: 'ADMIN' }},
  {path:'employees/add', component:EmployeeAddComponent, canActivate:[AuthGuard], data:{expectedRole: 'ADMIN' } },
  {path:'worklogs', component:WorklogComponent, canActivate:[AuthGuard] },
  {path:'worklogs/employee/:employeeId', component:EmployeeWorklogDetailComponent, canActivate:[AuthGuard] },
  {path:'worklogs/employee/:employeeId/add', component:EmployeeWorklogAddComponent, canActivate:[AuthGuard], data:{expectedRole: 'ADMIN' } },
  {path:'worklogs/employee/:worklogId/update', component:EmployeeWorklogUpdateComponent, canActivate:[AuthGuard], data:{expectedRole: 'ADMIN' } },
  {path:'', redirectTo:'/login', pathMatch:'full'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
