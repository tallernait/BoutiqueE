import { Component, OnInit, Input } from '@angular/core';
import { Product } from 'src/app/models/Product.models';
import { ServiceBoutique } from 'src/app/service.service';

@Component({
  selector: 'app-item',
  templateUrl: './item.component.html',
  styleUrls: ['./item.component.scss']
})
export class ItemComponent implements OnInit {

  @Input() product : Product;
  listProductPaid : Product [] = [];

  constructor( private service : ServiceBoutique) { }

  ngOnInit() {
   this.listProductPaid = this.service.getProductsListPaid()
  }

  onPlus(product : Product){
    if(!this.listProductPaid.includes(product))
        this.listProductPaid.push(product);
    else{
      let i = this.listProductPaid.indexOf(product);
      ++this.listProductPaid[i].quantity;
    }
    this.service.setTotal();
  }


}
