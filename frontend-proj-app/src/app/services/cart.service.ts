import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {CartCredentialsDTO} from '../model/CartCredentialsDTO';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CartService {
  baseURL:string="http://localhost:8080/customer-home";


  constructor(private httpClient:HttpClient) { }

  sendCartDetails(idProductsFromCart:any[],id:number,sum:string,iban:string,voucher:string){

    let credentials=new CartCredentialsDTO(idProductsFromCart,id,sum,iban,voucher)
    return this.httpClient.put(`${this.baseURL}/${id}`,credentials).subscribe();
  }
}
