export default class Orders{
  orderId:number;
  orderedDate:Date;
  totalSum:number;
  constructor(orderId:number,orderedDate:Date,totalSum:number ){
    this.orderId=orderId;
    this.orderedDate=orderedDate;
    this.totalSum=totalSum;

  }

}
