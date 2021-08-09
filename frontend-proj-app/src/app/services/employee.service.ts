import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import Employee from '../model/EmployeeModels';
import {Observable} from 'rxjs';
import {RegisterCredentialsDTO} from '../model/RegisterCredentialsDTO';
import {EmployeeCredentialsDTO} from '../model/EmployeeCredentialsDTO';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  baseURL:string="http://localhost:8080/employees";
  newURL:string="http://localhost:8080/admin-home/update-employee"
  constructor(private httpClient:HttpClient) {}
  getAllEmployees(){
    return this.httpClient.get<Employee[]>(this.baseURL);
  }
  saveEmployee(userName:string,password:string,firstName:string,lastName:string,email:string,address:string,phone:string,gender:string,zipcode:number,salary:number){
    return this.httpClient.put("",{userName:userName,password:password,firstName:firstName,lastName:lastName,email:email,address:address,phone:phone,gender:gender,zipcode:zipcode,salary:salary});
  }
  addEmployee(username:string,password:string,firstName:string,lastName:string,email:string,address:string,phone:string,gender:string,zipCode:number,salary:number){
    let credentials=new EmployeeCredentialsDTO(username,password,firstName,lastName,email,address,phone,gender,zipCode,salary);

    return this.httpClient.post("http://localhost:8080/admin-home/create-employee",credentials);

  }
  deleteEmployee(id:number):Observable<Object>{
    return this.httpClient.delete(`${this.baseURL}/${id}`)
  }
  updateEmployee(id:number,employee:Employee):Observable<Object>{
    return this.httpClient.put(`${this.newURL}/${id}`,employee);
  }


}
