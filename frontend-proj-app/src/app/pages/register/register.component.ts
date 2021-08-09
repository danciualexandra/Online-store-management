import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {LoginService} from '../../services/login.service';
import {Router} from '@angular/router';
import {RegisterService} from '../../services/register.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  registerForm:FormGroup;
  constructor(private formBuilder:FormBuilder,private service:RegisterService,private router:Router) { }

  ngOnInit(): void {
    this.initRegisterForm();
  }
  initRegisterForm(){
    this.registerForm=this.formBuilder.group({
      userName:[null, Validators.required,],
      password:[null,Validators.required],
      firstName:[null,Validators.required],
      lastName:[null,Validators.required],
      email:[null,Validators.required],
      address:[null,Validators.required],
      phone:[null,Validators.required,],
      gender:[null,Validators.required,],
      zipCode:[null,Validators.required,]
    })
  }
  get userName(){
    return this.registerForm.get('userName');
  }
  get password (){
    return this.registerForm.get('password');
  }
  get firstName (){
    return this.registerForm.get('firstName');
  }
  get lastName (){
    return this.registerForm.get('lastName');
  }
  get email (){
    return this.registerForm.get('email');
  }
  get address (){
    return this.registerForm.get('address');
  }
  get gender (){
    return this.registerForm.get('gender');
  }
  get phone(){
    return this.registerForm.get('phone');
  }
  get zipCode(){
    return this.registerForm.get('zipCode');
  }
  register(){


    this.service.register(this.userName.value,this.password.value,this.firstName.value,this.lastName.value,this.email.value,this.address.value,this.phone.value,this.gender.value,this.zipCode.value).subscribe((res:any)=>{


        this.router.navigate(["/login"]);


    });


  }
}
