import { Component, OnInit } from '@angular/core';
import { ServiceBoutique } from '../service.service';
import { Invoice } from '../models/Invoice.model';
import { Product } from '../models/Product.models';
import { Router } from '@angular/router';

@Component({
  selector: 'app-invoice',
  templateUrl: './invoice.component.html',
  styleUrls: ['./invoice.component.scss']
})
export class InvoiceComponent implements OnInit {

  nick : string;
  invoices : Invoice [] =[];
  total : number;
  date : Date;
  listP : Product[] = [];



  constructor(
    private service : ServiceBoutique , 
    private router : Router
  ) { 
    //service.idC
    
  }

  ngOnInit() {

    this.invoices = this.service.getInvoices();
    this.nick = this.service.cookie;                // il vient de la la cookie

    console.log("Appre init de Invoice");
    console.table(this.invoices)
  }

  onShowInvoice(invoice : Invoice){
    console.table(invoice);
    this.total = invoice.paidInv;
    this.date = invoice.date;
    this.listP = JSON.parse(invoice.productsInv);
  }
  onStore(){
    this.router.navigate(['store']);
  }

}
