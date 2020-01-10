import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable()
export class DataService {
    constructor(
        private http: HttpClient
    ){}

    loadCustomer(nick : String){
        return this.http.get('http://localhost:8080/storeJavaEE/api/customer/find/'+nick);
    } 

    loadProducts(){
        return this.http.get('http://localhost:8080/storeJavaEE/api/product/all');
    } 
}
