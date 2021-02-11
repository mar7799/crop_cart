import { Component, OnInit } from '@angular/core';
import { Router, Routes } from '@angular/router';
import { CropService } from '../crop.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})

export class LoginComponent implements OnInit {
  farmer: any;
  alert: boolean = false;

  constructor(public router: Router, public service: CropService) { }
  ngOnInit(): void {
  }

  async submitLoginForm(loginForm: any) {
    await this.service.getCredentials(loginForm.mobile, loginForm.password).toPromise().then((data: any) => { this.farmer = data; console.log(data); });
    if (this.farmer != null) {
      this.alert = true;
      this.service.setUserLoggedIn(this.farmer);
      this.router.navigate(['home']);
    } else {
      console.log("null");
    }
  }

  
  registerUser(regForm: any) {

    this.alert = true;
    this.service.register(regForm).subscribe((result: any) => console.log(result));
    this.service.myFunction2();
  }
  closeAlert() {
    this.alert = false;
  }


}
