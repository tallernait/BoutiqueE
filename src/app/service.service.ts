import { DataService } from './data.services';
import { Customer } from './models/Customers.model';
import { Injectable, OnInit } from '@angular/core';
import { Product } from './models/Product.models';
import { Invoice } from './models/Invoice.model';
import { CookieService } from 'ngx-cookie-service';

@Injectable()
export class ServiceBoutique implements OnInit {
    
    productsPaid : Product[] = [];
    invoice : Invoice[] = [] ;
    cookie :string = this.cookieService.get('nick');
    idC :number = Number(this.cookieService.get('IdC'));
    

    constructor(
        private data : DataService,
        private cookieService : CookieService
        ){}

    ngOnInit(): void {  }


    getCustomer(_customer :Customer){
         return this.data.loadCustomer(_customer);
    }
    getProducts(){
        return this.data.loadProducts();
    }

    getInvoices(){

        let list: Invoice[] = (JSON.parse(this.cookieService.get('invoices')));
        this.invoice = list;
        return this.invoice;
    }

    setInvoices(inv : Invoice[]){
        this.invoice = inv;
        console.log("Apres le set de la table");
        console.table(this.invoice)
    }

    
    addInvoice( invoice : Invoice){
        return this.data.addInvoice(invoice)
    }
    
    getProductsListPaid(){
        return this.productsPaid;
    }

    addProductsListPaid(product : Product){
        this.productsPaid.push(product);
    }
    
    removeProductsListPaid(id : number){
        this.productsPaid.splice(id,1);
    }

}