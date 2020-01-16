import { Component, OnInit, Output, Input } from '@angular/core';
import { Product } from '../models/Product.models';
import { ServiceBoutique } from '../service.service';
import { Invoice } from '../models/Invoice.model';
import { Router } from '@angular/router';
import { CookieService } from 'ngx-cookie-service';

@Component({
  selector: 'app-store',
  templateUrl: './store.component.html',
  styleUrls: ['./store.component.scss']
})
export class StoreComponent implements OnInit {

  products : Product[] = [];
  productsBuy : Product[] = [];
  total : number = 0;
  nick : string;
  idClient : number = 3;
  


  constructor(
      private service :ServiceBoutique,
      private router : Router,
      private cookieService: CookieService
      
    ){
       service.getProducts()
         .subscribe(
           (remoteProduct : Product[]) =>{
             this.products = remoteProduct;
           }
         ); 
      this.nick = this.service.cookie;   // Prenom  il vient de la la cookie
      this.idClient = this.service.idC;  // ID client il vient de la la cookie
     }

  ngOnInit() {
  this.productsBuy = this.service.getProductsListPaid();
  }

  onPayer(){
   
    let invoice = new Invoice(0, JSON.stringify(this.productsBuy) , this.total , this.idClient , new Date() );
    this.service.addInvoice( invoice )
        .toPromise()
        .then(
          (resp : Invoice[])  => {
            this.service.setInvoices(resp);
            
            let listString = JSON.stringify(resp);
            this.cookieService.set( 'invoices',listString );
            this.router.navigate(['invoices']);
          });    
  }

  onRemove(p : Product, i :number ){
    if(p.quantity > 1){
      --this.productsBuy[i].quantity;
    }else{
      this.service.removeProductsListPaid(i);
    }
    this.setTotal()
  }

  setTotal(){
        let total:number= 0;
        for (const p of this.productsBuy) {
           total += p.quantity * p.pricePro;
        }
        this.total =  total;
        console.log(this.total)
    }
 

}
