import { Component, OnInit } from '@angular/core';
import { CropService } from '../crop.service';
import { Router, Routes } from '@angular/router';

export interface Tile {
  cropName: string;
  cropType: string;
  price: number;
  image: string
 }

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  tiles: Tile[] = [];
 
  constructor(public service : CropService,public router: Router) {
    this.service.getAllCrop().toPromise().then((data: any) => { this.tiles = data; console.log(data); });
    console.log(this.tiles);
  }
  
  ngOnInit(): void {
  }

  buyCrop(tile : any){
    if(this.service.getBuyerLogged()){
      this.service.setBuyCrop(tile);
      this.router.navigate(['payment']);
    }
    else{
      this.router.navigate(['register']);
    }

  }

}