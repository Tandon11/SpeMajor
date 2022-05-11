import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Booking} from "../Models/booking.model";

@Injectable({
  providedIn: 'root'
})
export class BookingService {

  httpOptions = {
    headers :new HttpHeaders({
      'Content-Type':'application/json'
    })
  }

  constructor(private http: HttpClient) { }

  addBooking(bookingDetails: any) {
    return this.http.post('http://localhost:8090/booking/add', bookingDetails, this.httpOptions);
  }

  loadBooking(email: any) {
    return this.http.get('http://localhost:8090/booking/getByUser/'+email);
  }

  // makePayment(bookingDetails: any) {
  //   return this.http.post("http://localhost:8090/pay", bookingDetails);
  // }
}
