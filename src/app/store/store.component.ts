import { Component, OnInit } from '@angular/core';
import { Product } from '../models/Product.models';
import { ServiceBoutique } from '../service.service';

@Component({
  selector: 'app-store',
  templateUrl: './store.component.html',
  styleUrls: ['./store.component.scss']
})
export class StoreComponent implements OnInit {

  products : Product[] = [];
  total:number = 0;

  constructor(
      private service :ServiceBoutique
    ){
       service.getProducts()
         .subscribe(
           (remoteProduct : Product[]) =>{
             this.products = remoteProduct;
             console.log(this.products);
           }
         ); 

         
     }

  ngOnInit() {
    
  }

  onPayer(){

  }

}
