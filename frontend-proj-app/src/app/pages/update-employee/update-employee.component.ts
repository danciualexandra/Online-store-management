import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {MatSnackBar} from '@angular/material/snack-bar';
import {EmployeeService} from '../../services/employee.service';
import Employee from '../../model/EmployeeModels';
import {ActivatedRoute} from '@angular/router';

@Component({
  selector: 'app-update-employee',
  templateUrl: './update-employee.component.html',
  styleUrls: ['./update-employee.component.css']
})
export class UpdateEmployeeComponent implements OnInit {
  employeeForm:FormGroup;

  id:number;
  constructor(private updateBuilder:FormBuilder,  private snackBar:MatSnackBar , private employeeService:EmployeeService,private employeeBuilder:FormBuilder,private route:ActivatedRoute) { }

  ngOnInit(): void {
    this.initEmployeeForm();
    this.id=this.route.snapshot.params['id'];

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

  updateEmployee(){
  console.log(this.firstName.value);
   console.log(this.lastName.value);
    console.log(this.email.value);
    console.log(this.userName.value);
    console.log(this.password.value);
   console.log(this.phone.value);

    let employee=new Employee(this.userName.value,this.password.value,this.firstName.value,this.lastName.value,this.email.value,this.address.value,this.phone.value,this.gender.value,this.zipCode.value,this.salary.value);


    this.employeeService.updateEmployee(this.id,employee).subscribe((res:any)=>{

      // this.router.navigate(["/login"]);


    });


  }

}
