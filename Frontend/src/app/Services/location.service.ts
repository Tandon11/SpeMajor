import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import { Location } from '../Models/location.model';

@Injectable({
  providedIn: 'root'
})

export class LocationService {

  httpOptions = {
    headers :new HttpHeaders({
      'Content-Type':'application/json'
    })
  }

  constructor(private http: HttpClient) { }

  addLocation(location: any) {
    console.log(location);
    return this.http.post("http://localhost:8090/addLocation", location, this.httpOptions);
  }

  getLocation() {
    return this.http.get<Location[]>("http://localhost:8090/getAllLocation")
  }
}
