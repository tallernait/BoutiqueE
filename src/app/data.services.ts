import { Injectable } from '@angular/core';
import { HttpClient, HttpParams, HttpHeaders } from '@angular/common/http';
import { Invoice } from './models/Invoice.model';

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
    
    addInvoice( invoice :Invoice ){

        let body =  invoice;
        console.log(body);

        let headers = new HttpHeaders();
            headers.append('Content-Type', 'application/json');
            headers.append('Content-Type', 'text/plain');
            headers.append('Accept', 'application/json');

        return this.http.post<string>('http://localhost:8080/storeJavaEE/api/invoice/add' , body , {  headers : headers}
        );

    }
}
