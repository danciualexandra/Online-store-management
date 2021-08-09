import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {FirstComponent} from './pages/first/first.component';
import {LoginComponent} from './pages/login/login.component';
import {EmployeeHomeComponent} from './pages/employee-home/employee-home.component';
import {CustomerHomeComponent} from './pages/customer-home/customer-home.component';
import {CreateEmployeeComponent} from './create-employee/create-employee.component';
import {RegisterComponent} from './pages/register/register.component';
import {CreateProductComponent} from './create-product/create-product.component';
import {UpdateEmployeeComponent} from './pages/update-employee/update-employee.component';

import {UpdateProductComponent} from './pages/update-product/update-product.component';
import {DisplayChartComponent} from './pages/display-chart/display-chart.component';



const routes: Routes = [ {path:'admin-home',component: FirstComponent},
  {path:'login', component: LoginComponent},
  {path:'admin-home',component:FirstComponent},
  {path:'employee-home/:id',component:EmployeeHomeComponent},
  {path:'customer-home/:id',component:CustomerHomeComponent},
  {path:'employee-home/:id/create-employee',component:CreateEmployeeComponent},
  {path:'register',component:RegisterComponent},
  {path:'admin-home/create-employee',component:CreateEmployeeComponent},
  {path:'admin-home/create-product',component:CreateProductComponent},
  {path:'admin-home/update-employee/:id',component:UpdateEmployeeComponent},

  {path:'admin-home/update-product/:id',component:UpdateProductComponent},
  {path:'admin-home/display-chart',component:DisplayChartComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
