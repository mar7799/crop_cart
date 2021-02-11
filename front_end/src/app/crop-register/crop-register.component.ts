import { Component, OnInit } from '@angular/core';
import { Router, Routes } from '@angular/router';
import { CropService } from '../crop.service';

@Component({
  selector: 'app-crop-register',
  templateUrl: './crop-register.component.html',
  styleUrls: ['./crop-register.component.css']
})
export class CropRegisterComponent implements OnInit {
  crop : any;
  farmer:any;
  alert :boolean = false;
  constructor(public router: Router, public cropService : CropService ) {
   
  }

  ngOnInit(): void {
  }

  async registerCrop(cropRegForm : any){
  const cropDetails = {
    cropName : cropRegForm.cropName,
    cropType : cropRegForm.cropType,
    cropQuantity : cropRegForm.cropQuantity,
    place : cropRegForm.place,
    price : cropRegForm.price,
    farmer : this.cropService.farmer,
  }
  console.log(cropDetails.farmer);


  
    await this.cropService.registerCrop(cropDetails).toPromise().then((data : any) => { this.crop = data; console.log(data)});
    if(this.crop != null ){
      this.alert = true;
      this.router.navigate(['home']);
    }
  }
  closeAlert(){
    this.alert=false;
  }

}
