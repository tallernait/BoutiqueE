import { Component, OnInit } from '@angular/core';
import { Customer } from '../models/Customers.model';
import { ServiceBoutique } from '../service.service';
import { Router } from '@angular/router';
import { CookieService } from 'ngx-cookie-service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent {

  nick :string="";
  password :string="";
  customer : Customer = null;
 
  constructor(
    private service : ServiceBoutique ,
    private cookieService : CookieService,
    private router : Router
  ) { }

  ngOnInit() {
  }

  onValide(){
    let cLocal = new Customer(-1,this.nick," ", this.password, -1);
    
      this.service.getCustomer(cLocal)
      .subscribe(
        (c : Customer) =>{
          console.log(c);
          if(c != null){
            this.customer = c;
              console.log(`Bienvenido!!!! ${this.customer.name }`);

              this.cookieService.set( 'IdC', String(this.customer.iduser) );
              this.cookieService.set( 'nick', this.customer.name );
              this.cookieService.set( 'invoices', this.customer.name );
              
              this.service.cookie =  this.cookieService.get('nick');
              this.service.idC = Number(this.cookieService.get('IdC'));
              this.router.navigate(['store']);
           
          }

        }
      );
  
      

  }

}
