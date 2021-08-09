import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';


@Injectable({
  providedIn: 'root'
})
export class LoginService {
  baseURL:string="http://localhost:8080/login/success";
  logoutURL:string="http://localhost:8080/logout";
  connectedUsersURL:string="http://localhost:8080/connected-users";

  constructor(private httpClient:HttpClient) { }

  login(username:string,password:string){
    return this.httpClient.post(this.baseURL,{
      username:username,
      password:password
    })
  }

  logout(connectedUser:string){
    return this.httpClient.post(this.logoutURL,connectedUser).subscribe();
  }

  onlineUsers(){
    return this.httpClient.get<string>(this.connectedUsersURL);
  }
}
