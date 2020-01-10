import { DataService } from './data.services';
import { Customer } from './models/Customers.model';
import { Injectable } from '@angular/core';
import { Product } from './models/Product.models';

@Injectable()
export class ServiceBoutique {

    constructor( private data : DataService){}


    getCustomer(_nick :string){
         return this.data.loadCustomer(_nick);
    }
    getProducts(){
        return this.data.loadProducts();
    }
}