import { Component, OnInit, Output, Input } from '@angular/core';
import { Product } from '../models/Product.models';
import { ServiceBoutique } from '../service.service';

@Component({
  selector: 'app-store',
  templateUrl: './store.component.html',
  styleUrls: ['./store.component.scss']
})
export class StoreComponent implements OnInit {

  products : Product[] = [];
  productsBuy : Product[] = [];
  @Input() total : number = 909;


  constructor(
      private service :ServiceBoutique
    ){
       service.getProducts()
         .subscribe(
           (remoteProduct : Product[]) =>{
             this.products = remoteProduct;
           }
         ); 
     }

  ngOnInit() {
  this.productsBuy = this.service.getProductsListPaid();
  }

  onPayer(){

  }

  onInvoice(){

  }
  
  onRemove(p : Product, i :number ){
    if(p.quantity > 1){
      --this.productsBuy[i].quantity;
    }else{
      this.service.removeProductsListPaid(i);
    }
    this.service.setTotal()
  }

  

}
