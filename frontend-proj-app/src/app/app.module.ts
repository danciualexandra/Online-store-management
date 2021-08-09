import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {FirstComponent} from './pages/first/first.component';
import {HTTP_INTERCEPTORS, HttpClient, HttpClientModule} from '@angular/common/http';
import {MatListModule} from '@angular/material/list';
import { LoginComponent } from './pages/login/login.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {MatCardModule} from '@angular/material/card';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatInputModule} from '@angular/material/input';
import {MatTableModule} from '@angular/material/table';
import {MatButtonModule} from '@angular/material/button';
import {MatSnackBarModule} from '@angular/material/snack-bar';
import { EmployeeHomeComponent } from './pages/employee-home/employee-home.component';
import { CustomerHomeComponent } from './pages/customer-home/customer-home.component';
import { CreateEmployeeComponent } from './create-employee/create-employee.component';
import {RegisterComponent} from './pages/register/register.component';
import { CreateProductComponent } from './create-product/create-product.component';
import { UpdateEmployeeComponent } from './pages/update-employee/update-employee.component';
import {MatSelectModule} from '@angular/material/select';
import {MatIconModule} from '@angular/material/icon';
import { UpdateProductComponent } from './pages/update-product/update-product.component';
import { DisplayChartComponent } from './pages/display-chart/display-chart.component';
import {MatRadioModule} from '@angular/material/radio';
import {MatCheckboxDefaultOptions} from '@angular/material/checkbox';
import {InterceptorRequestService} from "./services/interceptor-request.service";




@NgModule({
  declarations: [
    AppComponent,
    FirstComponent,
    LoginComponent,
    EmployeeHomeComponent,
    CustomerHomeComponent,
    CreateEmployeeComponent,
    RegisterComponent,
    CreateProductComponent,
    UpdateEmployeeComponent,
    UpdateProductComponent,
    DisplayChartComponent


  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    HttpClientModule,
    MatListModule,
    ReactiveFormsModule,
    MatListModule,
    MatCardModule,
    MatFormFieldModule,
    MatSnackBarModule,
    MatButtonModule,
    MatInputModule,
    MatCardModule,
    MatTableModule,
    FormsModule,
    MatSelectModule,
    MatIconModule,
    MatRadioModule


  ],
  providers: [{
    provide: HTTP_INTERCEPTORS, useClass: InterceptorRequestService, multi: true
  }],
  bootstrap: [AppComponent]
})
export class AppModule { }
