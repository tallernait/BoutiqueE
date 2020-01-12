import { Component, OnInit } from '@angular/core';
import { Customer } from '../models/Customers.model';
import { ServiceBoutique } from '../service.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent {

  nick :string="";
  password :string="";
  customer : Customer= null;
 
  constructor(
    private service : ServiceBoutique ,
    private router : Router
  ) { }

  ngOnInit() {
  }

  onValide(){
      this.service.getCustomer(this.nick)
      .subscribe(
        (c : Customer) =>{
          //this.customer = c;

          if(c != null){
            if(c.password == this.password){
              this.customer = c;
              console.log(`Bienvenido!!!! ${this.customer.name}`);
              this.router.navigate(['store']);
            }
          }

        }
      );
  
      

  }

}
