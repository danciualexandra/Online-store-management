import {Component, Input, OnInit, Output, EventEmitter} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {ProductService} from '../../services/product.service';
import Product from '../../model/ProductModel';
import {MatSnackBar} from '@angular/material/snack-bar';
import {CartService} from '../../services/cart.service';
import {Observable} from 'rxjs';
import SockJS from 'sockjs-client';
import {Stomp} from '@stomp/stompjs';
import {LoginService} from "../../services/login.service";
import {VoucherService} from "../../services/voucher.service";
import {DiscountVoucher} from "../../model/DiscountVoucherModel";

@Component({
  selector: 'app-customer-home',
  templateUrl: './customer-home.component.html',
  styleUrls: ['./customer-home.component.css']
})

export class CustomerHomeComponent implements OnInit {
  id:number;
  baseUrl:string="customer-home";
  new:string="cart";
  productList:Product[];
  cartList:Product[];
  show:boolean=false;
  showCart:boolean=false;
  selectedPay:string="";
  disabled=false;
  checked=true;
  checkBox=false;
  idProductsFromCart=[];

  total:string;
  ibanForm:FormGroup;
  IBAN:string="";
  voucherInput:string="";
  voucherList:DiscountVoucher[];
  iban="";
  voucher="";
  voucherValidation=false;




  constructor(private formBuilder:FormBuilder,private route:ActivatedRoute,private router:Router,private productService:ProductService,private snackBar:MatSnackBar,private cartService:CartService,private loginService :LoginService,private voucherService:VoucherService) { }

  ngOnInit(): void {


    this.id=this.route.snapshot.params['id'];
   this.productService.getAllProducts().subscribe((res)=>{
     this.productList=res;
      },
      (_error)=>{

      });
    this.cartList = [];
    this.voucherService.getAllVouchers().subscribe((res)=>{
        this.voucherList=res;
      },
      (_error)=>{

      });

  }
  btnClick(){

    this.showCart=true;
    this.show=false;

  }
  viewClick(){
    this.show=true;
    this.showCart=false;
  }
  backClick(){
    this.show=false;
    this.showCart=false;
  }



  addToCart(product: Product){

    this.cartList.push(product);


  }
  removeFromCart(){

    this.cartList.pop();


  }
  computeSum(){
    let sum:number=0;
   for( var product of this.cartList){
     sum=sum+product.productPrice;
   }
   if(sum<100 && this.cartList.length==1){

     for(var product of this.cartList){
       sum=sum+product.shipDeliveryPrice;

     }

   }else if(sum<100 && this.cartList.length!=1){
     sum=sum +10.9;

   }
   if(this.cartList.length==0)
     sum=0;

  for(var vouch of this.voucherList){
  if(this.voucherValidation==true && vouch.voucherCode.localeCompare(this.voucherInput)==0)
  { var i;
    for(i = 0; i < this.voucherInput.length; i++){
     let  c = this.voucherInput.charAt(i);
      if( '0' <= c && c <= '9' )
        break;
    }
    let alphaPart = this.voucherInput.substring(0, i);
   let numberPart = this.voucherInput.substring(i);
    var number: number = +numberPart;
    sum=sum-(number/100)*sum;
  }}
    this.total= sum.toFixed(2);
    return sum.toFixed(2);


  }
  displayDelivery(){
    let sum:number=0;
    let delivery:number=0;
    for( var product of this.cartList){
      sum=sum+product.productPrice;
    }
    if(sum<100 && this.cartList.length==1){

      for(var product of this.cartList){

        delivery=product.shipDeliveryPrice;
      }


    }
    if(sum<100 && this.cartList.length!=1){

      delivery=10.90;
    }
    if(this.cartList.length==0)
      delivery=0;

    return delivery.toFixed(2);

  }
  logout(){
    this.loginService.logout(this.id.toString());
    this.router.navigate(['login']);

  }
  onChange(event){

    this.selectedPay=event.value;

  }
  payment(){

  if (this.selectedPay=="cash"){

    this.snackBar.open('The payment was successfully done.Pay at delivery method.' +
      'Check your email.', 'Undo', {
      duration: 3000
    });
  }else if(this.selectedPay=="card"){
    this.snackBar.open('The payment was successfully done.Payed with card' +
      'Check your email.', 'Undo', {
      duration: 3000
    });



  }
   this.takeDetailsFromCart();



  }


  showIbanField(){
    if(this.selectedPay=="card"){
      return true;

    }
    return false;

  }


  takeDetailsFromCart(){
    for(var product of this.cartList){
      this.idProductsFromCart.push(product.id);

    }

  }
  confirm(){

    this.iban=this.IBAN;
    this.voucher=this.voucherInput;
  this.sendCartDetails();
  this.cartList=[]
    this.idProductsFromCart=[];



  }
  sendCartDetails(){

    this.cartService.sendCartDetails(this.idProductsFromCart,this.id,this.total,this.iban,this.voucher);


  }
  newSum(){
   this.voucherValidation=true;

  }







}
