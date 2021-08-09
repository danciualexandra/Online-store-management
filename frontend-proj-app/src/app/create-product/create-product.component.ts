import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {ProductService} from '../services/product.service';

@Component({
  selector: 'app-create-product',
  templateUrl: './create-product.component.html',
  styleUrls: ['./create-product.component.css']
})
export class CreateProductComponent implements OnInit {

  productForm:FormGroup;
  constructor(private addProduct:FormBuilder,private productBuilder:FormBuilder,private productService:ProductService) { }

  ngOnInit(): void {
    this.initProductForm();
  }
  initProductForm(){
    this.productForm=this.productBuilder.group({
      productName:[null, Validators.required],
      productPrice:[null,Validators.required],
      quantity:[null,Validators.required],
      manufacturing:[null,Validators.required],
      expiration:[null,Validators.required],
      shipDeliveryPrice:[null,Validators.required],
     companyName:[null,Validators.required]

    })
  }
  get productName(){
    return this.productForm.get('productName');
  }
  get productPrice(){
    return this.productForm.get('productPrice');
  }
  get quantity(){
    return this.productForm.get('quantity');
  }
  get manufacturing(){
    return this.productForm.get('manufacturing');
  }
  get expiration(){
    return this.productForm.get('expiration');
  }
  get shipDeliveryPrice(){
    return this.productForm.get('shipDeliveryPrice');
  }
  get companyName(){
    return this.productForm.get('companyName');
  }
  createProduct(){

    this.productService.addProduct(this.productName.value,this.productPrice.value,this.quantity.value,this.manufacturing.value,this.expiration.value,this.shipDeliveryPrice.value,this.companyName.value).subscribe((res:any)=>{



    });
  }


}
