import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";

@Component({
  selector: 'app-home-section',
  templateUrl: './home-section.component.html',
  styleUrls: ['./home-section.component.css']
})
export class HomeSectionComponent implements OnInit {

  constructor(private router: Router) { }

  ngOnInit(): void {
  }

  checkSession(){
    if (sessionStorage.length == 0) {
      this.router.navigate(['/login'])
    }
    else {
      this.router.navigate(['/dashboard'])
    }
  }

}
