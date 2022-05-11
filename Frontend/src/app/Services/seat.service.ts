import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Seat} from "../Models/seat.model";
import {Show} from "../Models/show.model";

@Injectable({
  providedIn: 'root'
})
export class SeatService {

  httpOptions = {
    headers :new HttpHeaders({
      'Content-Type':'application/json'
    })
  }

  constructor(private http: HttpClient) { }

  addSeat(seat: any) {
    return this.http.post("http://localhost:8090/seat/add", seat, this.httpOptions);
  }

  getSeats() {
    return this.http.get<Seat[]>("http://localhost:8090/getAllSeats");
  }

  getSeatsById(theatreId: any, movieId: any, locationId: any, showId: any) {
    return this.http.get<Seat[]>(`http://localhost:8090/seats/getbyid/${movieId}/${locationId}/${theatreId}/${showId}`);
  }

  updateSeatById(seatId: any) {
    console.log('Update Function');
    console.log(seatId);
    return this.http.put(`http://localhost:8090/seats/updatebyid/${seatId}`, {});
  }

}
