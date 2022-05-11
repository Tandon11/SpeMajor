import { Component, OnInit } from '@angular/core';
import {BookingService} from "../../Services/booking.service";
import {Booking} from "../../Models/booking.model";
import {Router} from "@angular/router";


@Component({
  selector: 'app-booking',
  templateUrl: './booking.component.html',
  styleUrls: ['./booking.component.css']
})
export class BookingComponent implements OnInit {

  constructor(private bookingService: BookingService, private router: Router) { }

  email: any;
  bookingDetails: Booking[] = [];
  show: any;

  ngOnInit(): void {
    this.checkLogin();
    this.load();
  }

  load() {
    console.log("Inside Load");
    this.email = JSON.parse(sessionStorage.getItem('email') || '{}');

    console.log(this.email);
    this.bookingService.loadBooking(this.email).subscribe(
        (response: any) => {
          console.log(response);
          this.bookingDetails = response
          this.checkBookingFn();
        },
        (error:any)=>{
          console.log(error)
        }
    );
  }

  checkBookingFn(){
    console.log()
    if (this.bookingDetails.length == 0){
      this.show = true
    }
    else{
      this.show = false
    }
  }

  checkLogin(){
    if (sessionStorage.length == 0){
      this.router.navigate(['login']);
    }
  }

}
