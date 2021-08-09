import { Component, OnInit } from '@angular/core';
import Employee from '../../model/EmployeeModels';
import {EmployeeService} from '../../services/employee.service';
import Product from '../../model/ProductModel';
import {ProductService} from '../../services/product.service';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {ActivatedRoute, Router} from '@angular/router';
import SockJS from 'sockjs-client';
import {Stomp} from '@stomp/stompjs';
import {MatSnackBar} from "@angular/material/snack-bar";
import {Subscription} from "rxjs";
import {LoginService} from "../../services/login.service";
import { saveAs } from 'file-saver';
@Component({
  selector: 'app-first',
  templateUrl: './first.component.html',
  styleUrls: ['./first.component.css']
})
export class FirstComponent implements OnInit {

  id:number;
  employeeList:Employee[];
  productList:Product[];
  stompClient:any;
  nrOfUsers: Subscription ;



  constructor(private employeeService:EmployeeService,private loginService:LoginService,private productService:ProductService,private router:Router,private route:ActivatedRoute, private snackBar:MatSnackBar) { }

  ngOnInit(): void {



    this.employeeService.getAllEmployees().subscribe((res)=>{

        this.employeeList=res;
      },
      (_error)=>{

      });

    this.productService.getAllProducts().subscribe((res)=>{

        this.productList=res;
      },
      (_error)=>{

      });

this.subscribeToNotifications();
    this.initNrOfUsers();
  }
  initNrOfUsers(){
    this.loginService.onlineUsers().subscribe((res:any)=>{
      this.nrOfUsers=res;
    });
  }


  deleteEmployee(id:number){
    this.employeeService.deleteEmployee(id).subscribe((data=>{

      this.employeeService.deleteEmployee(id);


    }))

  }
  deleteProduct(id:number){
    this.productService.deleteProduct(id).subscribe((data=>{

      this.productService.deleteProduct(id);



    }))

  }
  updateEmployee(id:number){
    this.router.navigate(['admin-home/update-employee',id]);
  }
  updateProduct(id:number){
    this.router.navigate(['admin-home/update-product',id]);
  }
  logout(){
    this.router.navigate(['login']);
  }

  subscribeToNotifications(){
    const URL="http://localhost:8080/socket";
    const websocket=new SockJS(URL);
    this.stompClient=Stomp.over(websocket);
    this.stompClient.connect({},()=>{
      this.stompClient.subscribe('/topic/socket/admin-home', notification=>{
        let message=notification.body;

        this.snackBar.open(message,'Close',{
          duration:3000
        })
      })
    });
  }
  exportData(fileType:string,productId:number){
    this.productService.exportProductDetails(productId,fileType).subscribe((res)=>{
      if(res){
        let typeForBlob= fileType == 'txt' ? 'text/plain;charset=utf-8' : 'text/xml;charset=utf-8';
        let blob=new Blob([res],{type:typeForBlob});
        saveAs(blob,"product-data."+fileType);
      }
    })
  }





}
