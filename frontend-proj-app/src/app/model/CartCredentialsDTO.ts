export class CartCredentialsDTO{
  idProductsFromCart:any[];
  id:number;
  sum:string;
  iban:string;
  voucher:string;


  constructor(idProductFromCart:any[],id:number,sum:string,iban:string,voucher:string){
    this.idProductsFromCart=idProductFromCart;
    this.id=id;
    this.sum=sum;
    this.iban=iban;
    this.voucher=voucher;
  }


}
