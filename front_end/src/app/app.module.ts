import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {MatGridListModule} from '@angular/material/grid-list';
import {MatTabsModule} from '@angular/material/tabs';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { FormsModule } from '@angular/forms';
import { HeaderComponent } from './header/header.component';
import { RouterModule, Routes } from '@angular/router';
import { AuthGuard } from './auth.guard';
import { HomeComponent } from './home/home.component';
import { HttpClientModule} from '@angular/common/http';
import { CropRegisterComponent } from './crop-register/crop-register.component';
import { CustomerRegisterComponent } from './customer-register/customer-register.component';
import { OrdersComponent } from './orders/orders.component';
import { from } from 'rxjs';
import { PaymentComponent } from './payment/payment.component';
import { DatePipe } from './date.pipe';

const appRoot:Routes = [{path:'', component:HomeComponent },
{path:'home', component:HomeComponent },
{path:'login', component:LoginComponent},
{path:'payment', component:PaymentComponent},
{path:'register',component:RegisterComponent},
{path:'orders',component:OrdersComponent},
{path:'registercustomer', component:CustomerRegisterComponent },
{path:'registerCrop',component:CropRegisterComponent}]


@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegisterComponent,
    HeaderComponent,
    HomeComponent,
    CropRegisterComponent,
    CustomerRegisterComponent,
    OrdersComponent,
    PaymentComponent,
    DatePipe
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    RouterModule.forRoot(appRoot),
    HttpClientModule,
    MatGridListModule,
    MatTabsModule
    
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
