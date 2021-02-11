import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import {Router}from '@angular/router';
import * as d3 from 'd3';

@Injectable({
  providedIn: 'root'
})
export class CropService {
   
   
  public isBuyerLogged : boolean;
  public isUserLogged : boolean;
  public isSignUpClicked : boolean;
  public isSignInClicked : boolean;
  public farmer : any;
  public buyCrop : any;
  public customer : any;

 
  constructor(public httpClient : HttpClient, public router:Router) { 
    this.isUserLogged = false; 
    this.isBuyerLogged = false;
    this.isSignUpClicked = false;
    this.isSignInClicked = false;
    this.farmer = null;
    this.buyCrop = null;
    this.customer = null;
    }
  
    myFunction() {
      this.isSignUpClicked = true;
     
      if(this.isSignUpClicked)
      {
        d3.selectAll(".container").classed("right-panel-active", true);
      }
   
  }

  myFunction2(){
    this.isSignInClicked = true;
    if(this.isSignInClicked){
      d3.selectAll(".container").classed("right-panel-active", false);
    }
  }


  public setBuyerLoggedIn(customer : any):any{
    this.isBuyerLogged = true;
    this.customer = customer;
  }
  public getBuyerLogged():any{
    return this.isBuyerLogged;
  }

  public setBuyerLoggedOut():any{
    this.isBuyerLogged = false;
    this.router.navigate(['home']); 
  }
  
  public setUserLoggedIn(farmer : any):any{
    this.farmer = farmer;
    this.isUserLogged = true;
  }
  public getUserLogged():any{
    return this.isUserLogged;
  }

  public setUserLoggedOut():any{
    this.isUserLogged = false;
  
    this.router.navigate(['login']); 
  }
  public setBuyCrop(buyCrop : any){
    this.buyCrop = buyCrop;
  }
  public getBuyCrop() : any{
    return this.buyCrop;
  }
  
  register(regform : any):any{
    return this.httpClient.post('/registerFarmer/', regform);
  }
  
  registerCustomer(customerRegForm : any):any{
    return this.httpClient.post('/registerCustomer/', customerRegForm);
  }
   
  registerCrop(cropRegform : any):any{
    return this.httpClient.post('/registerCrop/', cropRegform);
  }

   
  registerOrders(orders : any):any{
    return this.httpClient.post('/registerOrders/', orders);
  }

  registerOrderDetails(orderDetails : any):any{
    console.log("registerOrderDetails " +orderDetails.orderQuantity);

    return this.httpClient.post('/registerOrderDetails/', orderDetails);
    
  }

  
  
  getCredentials(mobile:any,password: any):any{
    return this.httpClient.get('/getFarmerByMobilePassword/' + mobile +'/' +password);
  }
  getCustomerCredentials(mobile:any,password: any):any{
    return this.httpClient.get('/getCustomerByMobilePassword/' + mobile +'/' +password);
  }
  getAllCrop():any{
    return this.httpClient.get('/getAllCrop' );
  }

  getAllCropByFarmer(farmerId:any):any{
    return this.httpClient.get('/getAllCropByFarmer/' + farmerId );
  }

}