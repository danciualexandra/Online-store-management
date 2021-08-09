import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {RegisterCredentialsDTO} from '../model/RegisterCredentialsDTO';

@Injectable({
  providedIn: 'root'
})
export class RegisterService {
  baseURL:string="http://localhost:8080/register";

  constructor(private httpClient:HttpClient) { }


  register(username:string,password:string,firstName:string,lastName:string,email:string,address:string,phone:string,gender:string,zipCode:number){
    let credentials=new RegisterCredentialsDTO(username,password,firstName,lastName,email,address,phone,gender,zipCode);

    return this.httpClient.post(this.baseURL,credentials);



  }
}
