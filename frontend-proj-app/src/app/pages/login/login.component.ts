import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {LoginService} from '../../services/login.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
   loginForm:FormGroup;
  nrOfUsers:number ;
  constructor(private formBuilder:FormBuilder,private service:LoginService,private router:Router) { }

  ngOnInit(): void {
    this.initLoginForm();
  }
  initLoginForm(){
    this.loginForm=this.formBuilder.group({
      username:[null, Validators.required,],
      password:[null,Validators.required]
    })
  }
  login(){
    const username=this.loginForm.value.username;
    const password=this.loginForm.value.password;
    this.service.login(username,password).subscribe((res:any)=> {
        let role = res.role;
        localStorage.setItem("token", 'Basic ' + btoa(username + ":" + password));
        if (role == "ADMIN") {
          this.router.navigate(["/admin-home"]);
        } else if (role == "EMPLOYEE") {
          this.router.navigate(["/employee-home/" + res.id]);
        } else if (role == "CUSTOMER") {
          this.router.navigate(["/customer-home/" + res.id]);
        }
      }
      ,(_error)=>{
        alert("Invalid username or password");
      }

    );


    this.service.onlineUsers().subscribe((res:any)=>{
      this.nrOfUsers=res;
    });

  }


  register(){
    this.router.navigate(['register']);
  }

}
