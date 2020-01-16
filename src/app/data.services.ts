import { Injectable } from '@angular/core';
import { HttpClient, HttpParams, HttpHeaders } from '@angular/common/http';
import { Invoice } from './models/Invoice.model';
import { Observable } from 'rxjs';
import { Customer } from './models/Customers.model';

@Injectable()
export class DataService {
        
    constructor(
        private http: HttpClient
    ){ }

    loadCustomer(Customers : Customer): Observable<any>{
        let body =  Customers;
        let headers =  new HttpHeaders;
            headers.append('Content-Type', 'application/json');
            headers.append('Content-Type', 'text/plain');
            headers.append('Accept', 'application/json');

        console.log(JSON.stringify(body) + " ------------------------" );
        return this.http.post<string>('http://localhost:8080/storeJavaEE/api/customer/userok' , body , {  headers : headers}
        );
    } 

    loadProducts(){
        return this.http.get('http://localhost:8080/storeJavaEE/api/product/all');
    }

    loadInvoice(idC : number): Observable<any>{
        console.log(`el id de la factura es ${idC} `)
        return this.http.get('http://localhost:8080/storeJavaEE/api/invoice/'+idC);
    }
    
    addInvoice( invoice :Invoice ) : Observable<any> {

        let body =  invoice;
        let headers =  new HttpHeaders;
            headers.append('Content-Type', 'application/json');
            headers.append('Content-Type', 'text/plain');
            headers.append('Accept', 'application/json');

        console.log(body);
        return this.http.post<string>('http://localhost:8080/storeJavaEE/api/invoice/add' , body , {  headers : headers}
        );

    }
}
