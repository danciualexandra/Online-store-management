import { Component, OnInit } from '@angular/core';
import Employee from '../model/EmployeeModels';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {MatSnackBar} from '@angular/material/snack-bar';
import {EmployeeService} from '../services/employee.service';

@Component({
  selector: 'app-create-employee',
  templateUrl: './create-employee.component.html',
  styleUrls: ['./create-employee.component.css']
})
export class CreateEmployeeComponent implements OnInit {

  employeeForm:FormGroup;

  constructor( private addBuilder:FormBuilder,  private snackBar:MatSnackBar , private employeeService:EmployeeService,private employeeBuilder:FormBuilder) { }

  ngOnInit(): void {

    this.initEmployeeForm();
  }
  initEmployeeForm(){
    this.employeeForm=this.employeeBuilder.group({
      userName:[null, Validators.required],
      password:[null,Validators.required],
      firstName:[null,Validators.required],
      lastName:[null,Validators.required],
      email:[null,Validators.required],
      address:[null,Validators.required],
      phone:[null,Validators.required],
      gender:[null,Validators.required],
      zipCode:[null,Validators.required],
      salary:[null,Validators.required],
    })
  }
  get userName(){
    return this.employeeForm.get('userName');
  }
  get password (){
    return this.employeeForm.get('password');
  }
  get firstName (){
    return this.employeeForm.get('firstName');
  }
  get lastName (){
    return this.employeeForm.get('lastName');
  }
  get email (){
    return this.employeeForm.get('email');
  }
  get address (){
    return this.employeeForm.get('address');
  }
  get gender (){
    return this.employeeForm.get('gender');
  }
  get phone(){
    return this.employeeForm.get('phone');
  }

  get salary(){
    return this.employeeForm.get('salary');
  }
  get zipCode(){
    return this.employeeForm.get('zipCode');
  }
  createEmployee(){


    this.employeeService.addEmployee(this.userName.value,this.password.value,this.firstName.value,this.lastName.value,this.email.value,this.address.value,this.phone.value,this.gender.value,this.zipCode.value,this.salary.value).subscribe((res:any)=>{



    });


  }


}
