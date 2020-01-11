import { Component } from '@angular/core';
import { ServiceBoutique } from './service.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'Boutique E';

  constructor(
    private service : ServiceBoutique
  ){}

  getTotal(){
    return this.service.getTotal();
  };
}
