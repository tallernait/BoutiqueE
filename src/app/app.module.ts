import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule} from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { HttpClientModule } from '@angular/common/http';
import { ServiceBoutique } from './service.service';
import { DataService } from './data.services';
import { StoreComponent } from './store/store.component';
import { ItemComponent } from './store/item/item.component';
import { ErrorComponent } from './error/error.component';
import { InvoiceComponent } from './invoice/invoice.component';
import { CookieService } from 'ngx-cookie-service';


@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    StoreComponent,
    ItemComponent,
    ErrorComponent,
    InvoiceComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [ServiceBoutique, DataService , CookieService],
  bootstrap: [AppComponent]
})
export class AppModule { }
