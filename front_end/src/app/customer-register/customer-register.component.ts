import { Component, OnInit } from '@angular/core';
import { CropService } from '../crop.service';

@Component({
  selector: 'app-customer-register',
  templateUrl: './customer-register.component.html',
  styleUrls: ['./customer-register.component.css']
})
export class CustomerRegisterComponent implements OnInit {
  alert :boolean = false;

  constructor(public cropService:CropService) { }

  ngOnInit(): void {
  }

  registerCustomer(customerRegForm:any){
    console.log(customerRegForm);
    this.alert =true;
    this.cropService.registerCustomer(customerRegForm).subscribe((result : any) => console.log(result));
  }
  closeAlert(){
    this.alert=false;
  }
  

}
