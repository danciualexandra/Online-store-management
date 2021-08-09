import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import Product from "../model/ProductModel";
import {DiscountVoucher} from "../model/DiscountVoucherModel";


@Injectable({
  providedIn: 'root'
})
export class VoucherService {
  baseURL:string="http://localhost:8080/vouchers";
  constructor(private httpClient:HttpClient) { }
  getAllVouchers(){
    return this.httpClient.get<DiscountVoucher[]>(this.baseURL);
  }
}
