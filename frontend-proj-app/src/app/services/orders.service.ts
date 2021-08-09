import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import Product from "../model/ProductModel";
import Orders from "../model/Orders";

@Injectable({
  providedIn: 'root'
})
export class OrdersService {
  baseURL:string="http://localhost:8080/orders";
  constructor(private httpClient:HttpClient) { }
  getAllOrders(){
    return this.httpClient.get<Orders[]>(this.baseURL);
  }
}
