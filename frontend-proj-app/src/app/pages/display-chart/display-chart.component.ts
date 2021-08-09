import {Component, OnInit, ViewChild} from '@angular/core';
import * as Chart from 'chart.js'
import Product from '../../model/ProductModel';
import {ProductService} from '../../services/product.service';
import {OrdersService} from "../../services/orders.service";
import Orders from "../../model/Orders";



@Component({
  selector: 'app-display-chart',
  templateUrl: './display-chart.component.html',
  styleUrls: ['./display-chart.component.css']
})
export class DisplayChartComponent implements OnInit {

  productList:Product[];
  ordersList:Orders[];

  companies=[];
  stock=[];
  expirationYears=[];
  sortYears=[];
  sumPerOreder=[];
  orderTime=[];

  constructor(private productService:ProductService,private orderService:OrdersService) { }

  ngOnInit(): void {


   this.orderService.getAllOrders().subscribe((res)=>{
     this.ordersList=res;
     for(let res of this.ordersList){

       this.sumPerOreder.push(res.totalSum);
       let stringDate=res.orderedDate.toString();
       let parts=stringDate.split(".");
       let date=parts[0];

       this.orderTime.push(date);

     }

   });


    this.productService.getAllProducts().subscribe((res)=>{

        this.productList=res;

       for(let res of this.productList){

         let stringDate=res.expiration.toString();
         let parts=stringDate.split("-");
         let year=parts[0];
         this.expirationYears.push(year);

         this.sortYears=this.expirationYears.filter((x, i, a) => a.indexOf(x) == i);
         this.companies.push(res.companyName);
         this.stock.push(res.quantity);




       }
      },
      (_error)=>{

      });



  }

  canvas: any;
  canvas2:any;
  ctx: any;
  ctx2:any;
  @ViewChild('mychart') mychart:any;
  @ViewChild('mychart2') mychart2:any;


  ngAfterViewInit() {
    this.canvas = this.mychart.nativeElement;
    this.ctx = this.canvas.getContext('2d');

    new Chart(this.ctx, {
      type: 'horizontalBar',
      data: {
        datasets: [{
          label: 'Current value',

          data:this.stock,

          backgroundColor: "rgb(115 185 243 / 65%)",
         borderColor: "#007ee7",
          fill: true,
        },

      ],

        labels:this.companies,

      },
    });

    this.canvas2 = this.mychart2.nativeElement;
    this.ctx2 = this.canvas2.getContext('2d');

    new Chart(this.ctx2, {
      type: 'line',
      data: {
        datasets: [{
          label: 'Orders amount',

          data:this.sumPerOreder,
          backgroundColor: "rgb(115 185 243 / 65%)",
          borderColor: "#007ee7",
          fill: true,
        },

        ],

        labels:this.orderTime

      },
    });




  }










}
