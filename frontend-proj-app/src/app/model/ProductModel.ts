export default class Product{
  id:number;
  productName:string;
  productPrice:number;
  quantity:number;
  manufacturing:Date;
  expiration:Date;
  shipDeliveryPrice:number;
  companyName:string;
  constructor( productName:string,productPrice:number, quantity:number, manufacturing:Date,expiration:Date,shipDeliveryPrice:number,  companyName:string) {
    this.productName=productName;
    this.productPrice=productPrice;
    this.quantity=quantity;
    this.manufacturing=manufacturing;
    this.expiration=expiration;
    this.shipDeliveryPrice=shipDeliveryPrice;
    this.companyName=companyName;
  }

}
