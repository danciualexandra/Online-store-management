import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {MatSnackBar} from '@angular/material/snack-bar';
import {EmployeeService} from '../../services/employee.service';
import {ActivatedRoute} from '@angular/router';
import Product from '../../model/ProductModel';
import {ProductService} from '../../services/product.service';

@Component({
  selector: 'app-update-product',
  templateUrl: './update-product.component.html',
  styleUrls: ['./update-product.component.css']
})
export class UpdateProductComponent implements OnInit {
  productForm:FormGroup;

  id:number;
  constructor(private updateBuilder:FormBuilder,  private snackBar:MatSnackBar , private productService:ProductService,private productBuilder:FormBuilder,private route:ActivatedRoute) { }

  ngOnInit(): void {
    this.initProductForm();
    this.id=this.route.snapshot.params['id'];
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

  updateProduct(){

    let product=new Product(this.productName.value,this.productPrice.value,this.quantity.value,this.manufacturing.value,this.expiration.value,this.shipDeliveryPrice.value,this.companyName.value)

    this.productService.updateProduct(this.id,product).subscribe((res:any)=>{




    });




  }








}
