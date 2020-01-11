import { DataService } from './data.services';
import { Customer } from './models/Customers.model';
import { Injectable } from '@angular/core';
import { Product } from './models/Product.models';

@Injectable()
export class ServiceBoutique {
    
    productsPaid : Product[] = [];
    total : number = 0;


    constructor( private data : DataService){}

    getCustomer(_nick :string){
         return this.data.loadCustomer(_nick);
    }
    getProducts(){
        return this.data.loadProducts();
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

    setTotal(){
        let total:number= 0;
        for (const p of this.productsPaid) {
           total += p.quantity * p.pricePro;
        }
        this.total =  total;
        console.log(this.total)
    }
    getTotal(){
        return this.total;
    }

}