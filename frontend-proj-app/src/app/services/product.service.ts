import { Injectable } from '@angular/core';
import {HttpClient, HttpParams} from '@angular/common/http';
import Product from '../model/ProductModel';
import {EmployeeCredentialsDTO} from '../model/EmployeeCredentialsDTO';
import {ProductCredentialsDTO} from '../model/ProductCredentialsDTO';
import {Observable} from 'rxjs';
import {resolve} from '@angular/compiler-cli/src/ngtsc/file_system';


@Injectable({
  providedIn: 'root'
})
export class ProductService {

  baseURL:string="http://localhost:8080/products";
  newURL:string="http://localhost:8080/admin-home/update-product"
  exportURL:string="http://localhost:8080"
  constructor(private httpClient:HttpClient) {}

  getAllProducts(){
    return this.httpClient.get<Product[]>(this.baseURL);
  }

  addProduct(productName:string,productPrice:number,quantity:number,manufacturing:Date,expiration:Date,shipDeliveryPrice:number,companyName:string){

    let credentials=new ProductCredentialsDTO(productName,productPrice,quantity,manufacturing,expiration,shipDeliveryPrice,companyName);
    return this.httpClient.post("http://localhost:8080/admin-home/create-product",credentials);



  }
  deleteProduct(id:number):Observable<Object>{
    return this.httpClient.delete(`${this.baseURL}/${id}`)
  }
  findProductByName(name:string){
    return this.httpClient.get("http://localhost:8080/find")

  }
  updateProduct(id:number,product:Product):Observable<Object>{
    return this.httpClient.put(`${this.newURL}/${id}`,product);

  }
  exportProductDetails(productId:number, fileType:string){
    return this.httpClient.get(this.exportURL+"/export/"+productId,{
      params:{fileType:fileType},
      responseType: 'text'
    })
  }





}
