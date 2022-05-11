import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Show} from "../Models/show.model";

@Injectable({
  providedIn: 'root'
})
export class ShowService {

  httpOptions = {
    headers :new HttpHeaders({
      'Content-Type':'application/json'
    })
  }

  constructor(private http: HttpClient) { }

  addShow(show: any) {
    return this.http.post("http://localhost:8090/shows/add", show, this.httpOptions);
  }

  getAllShows() {
    return this.http.get<Show[]>("http://localhost:8090/shows/getAll");
  }

  getShowById(theatreId: any, movieId: any, locationId: any) {
    return this.http.get<Show[]>(`http://localhost:8090/shows/getbyid/${movieId}/${locationId}/${theatreId}`);
  }
}
