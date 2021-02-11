import { Component, OnInit } from '@angular/core';
import { CropService } from '../crop.service';
import { Router, Routes } from '@angular/router';
import { toast } from 'materialize-css';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  customer:any;
  alert :boolean = false;
  constructor( public service : CropService ,public router: Router) {
   
   }

  ngOnInit(): void {
  }
  async submitLoginForm(loginForm: any) {
    await this.service.getCustomerCredentials(loginForm.customerMobileNo, loginForm.password).toPromise().then((data: any) => { this.customer = data; console.log(data); });
      if (this.customer!= null) {
        this.alert = true;
        this.service.setBuyerLoggedIn(this.customer);
        this.router.navigate(['home']);
      } else{
        console.log("null");
      }
  }
  
  registerCustomer(customerRegForm:any){
    console.log(customerRegForm);
    //this.alert =true;
    this.service.registerCustomer(customerRegForm).subscribe((result : any) =>{ this.customer = result; console.log(result); });
    if(this.customer!=null){
      this.service.myFunction2();
      
    }
  }
  closeAlert(){
    this.alert=false;
  }

}
