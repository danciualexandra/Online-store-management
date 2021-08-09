import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import Product from '../../model/ProductModel';
import {ProductService} from '../../services/product.service';
import {LoginService} from "../../services/login.service";

@Component({
  selector: 'app-employee-home',
  templateUrl: './employee-home.component.html',
  styleUrls: ['./employee-home.component.css']
})
export class EmployeeHomeComponent implements OnInit {
  productList:Product[];
  id:number;
  pName:string;
  filter={
    field:'',
    criteria:'',
    filtervalue:''
  };
  constructor(private loginService :LoginService,private route:ActivatedRoute,private productService:ProductService ,private router:Router ) { }

  ngOnInit(): void {
    this.id=this.route.snapshot.params['id'];
    this.productService.getAllProducts().subscribe((res)=>{

        this.productList=res;
      },
      (_error)=>{

      });

  }
  search(){
    this.productList=this.productList.filter(res=>{
         return res.productName.toLocaleLowerCase().match(this.pName.toLocaleLowerCase());
    });
  }
  filterData(){
    var price:number=+this.filter.filtervalue;

    this.productList=this.productList.filter(res=>{
      if(this.filter.criteria=='==')
      return res.productPrice.toPrecision().match(this.filter.filtervalue);
      if(this.filter.criteria=='<'){
        if(res.productPrice< price){
          return res;
        }
      }else if(this.filter.criteria=='>'){
        if(res.productPrice>price){
          return res;
        }
      }

      if(this.filter.criteria=="before"){
        let stringDate=res.expiration.toString();
        let parts=stringDate.split("-");
        let year=parts[0];

        if(year<=this.filter.filtervalue){
          return res;
        }

      }else if(this.filter.criteria=="after"){
        let stringDate=res.expiration.toString();
        let parts=stringDate.split("-");
        let year=parts[0];

        if(year>this.filter.filtervalue){
          return res;
        }

      }


    })
  }
  logout(){
    this.loginService.logout(this.id.toString());
    this.router.navigate(['login']);

  }






}
