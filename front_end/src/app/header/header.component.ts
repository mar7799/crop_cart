import { Component, OnInit } from '@angular/core';
import { CropService } from '../crop.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  constructor(public service: CropService) { }

  ngOnInit(): void {
  }

}
