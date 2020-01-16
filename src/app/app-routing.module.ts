import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { ErrorComponent } from './error/error.component';
import { StoreComponent } from './store/store.component';
import { InvoiceComponent } from './invoice/invoice.component';


const routes: Routes = [
  {path: '' , component: LoginComponent},
  {path: 'store', component: StoreComponent}, 
  {path: 'invoices', component: InvoiceComponent}, 
  {path: '**', component: ErrorComponent}
]

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
