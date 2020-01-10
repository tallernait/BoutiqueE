import { Component, OnInit, Input } from '@angular/core';
import { Product } from 'src/app/models/Product.models';

@Component({
  selector: 'app-item',
  templateUrl: './item.component.html',
  styleUrls: ['./item.component.scss']
})
export class ItemComponent implements OnInit {

  @Input() product : Product;


  
  constructor() { }

  ngOnInit() {
  }

  onPlus(){
  }

}
