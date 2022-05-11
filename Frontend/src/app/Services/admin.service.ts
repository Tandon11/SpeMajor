import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class AdminService {

  constructor(private http: HttpClient) { }

  httpOptions = {
    headers :new HttpHeaders({
      'Content-Type':'application/json'
    })
  }

  loginCheck(credentials: any) {
    console.log(credentials);
    return this.http.post<Boolean>('http://localhost:8090/admin', credentials, this.httpOptions);
  }
}
