import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  show: any;

  constructor() { }

  ngOnInit(): void {
    this.loginCheck()
  }

  loginCheck() {
    if(sessionStorage.length == 0)
      this.show = true;
    else
      this.show = false;
  }

}
