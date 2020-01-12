import { Component, OnInit, Output, Input } from '@angular/core';
import { Product } from '../models/Product.models';
import { ServiceBoutique } from '../service.service';
import { Invoice } from '../models/Invoice.model';

@Component({
  selector: 'app-store',
  templateUrl: './store.component.html',
  styleUrls: ['./store.component.scss']
})
export class StoreComponent implements OnInit {

  products : Product[] = [];
  productsBuy : Product[] = [];
  @Input()total : number = 909;
  @Input() idClient : number = 3;
  


  constructor(
      private service :ServiceBoutique,
      
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
   
    let invoice = new Invoice(-1, JSON.stringify(this.productsBuy) , this.total , this.idClient , new Date() );
    
    this.service.addInvoice( invoice )
        .subscribe(
          resp => {
            console.log("response %o, ", resp);
          });
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
