import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Theatre} from "../Models/theatre.model";

@Injectable({
  providedIn: 'root'
})
export class TheatreService {

  httpOptions = {
    headers :new HttpHeaders({
      'Content-Type':'application/json'
    })
  }

  constructor(private http: HttpClient) { }

  addTheatre(theatre: any) {
    return this.http.post("http://localhost:8090/theatre/add", theatre, this.httpOptions);
  }

  getAllTheatre() {
    return this.http.get<Theatre[]>("http://localhost:8090/theatre");
  }

  getTheatreById(locationid: any, movieid: any) {
    console.log(locationid + movieid);
    return this.http.get<Theatre[]>(`http://localhost:8090/getTheatre/${locationid}/${movieid}`);
  }
}
