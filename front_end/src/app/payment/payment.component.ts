import { Component, OnInit } from '@angular/core';
import { CropService } from '../crop.service';
import { Router, Routes } from '@angular/router';

@Component({
  selector: 'app-payment',
  templateUrl: './payment.component.html',
  styleUrls: ['./payment.component.css']
})
export class PaymentComponent implements OnInit {
  buyCrop :any;
  deliveryAddress : any;
  orders : any;
  orderDetails : any;

  constructor(public service : CropService,public router: Router,) {
    this.buyCrop = this.service.getBuyCrop();
   }

  ngOnInit(): void {
    
  }

  placeOrder(placeOrderForm : any){
    //console.log(placeOrderForm.name);
    this.deliveryAddress =  placeOrderForm.name + "\n" + placeOrderForm.address + "\n" + placeOrderForm.postcode + "\n" + placeOrderForm.phone + "\n" +placeOrderForm.emailId;
    //console.log(this.deliveryAddress);
   const orders = {
      orderStatus : "Processing",
      //orderDate :{Date},
      deliveryAddress : this.deliveryAddress,
      customer : this.service.customer
     };
     console.log(orders);
    this.service.registerOrders(orders).subscribe((result : any) =>{ this.orders = result; console.log(result); });
    if(this.orders!=null){
      const orderDetails = {
        orderQuantity : this.buyCrop.cropQuantity,
        totalPrice :((this.buyCrop.cropQuantity)*(this.buyCrop.price)),
        crop : this.buyCrop,
        orders : this.orders,

        
       };
       console.log("inside payment component" +orderDetails.orderQuantity);
      this.service.registerOrderDetails(orderDetails) .subscribe((result : any) =>{ this.orderDetails = result; console.log(result); });
      if(orderDetails!=null){ 
        this.router.navigate(['orders']);
      }
      
      
    }
  }



}
