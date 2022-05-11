import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})

export class UserService {

  httpOptions = {
    headers :new HttpHeaders({
      'Content-Type':'application/json'
    })
  }

  constructor(private http: HttpClient) { }

  loginCheck(loginCredentials: any) {
    return this.http.post('http://localhost:8090/user/login', loginCredentials, this.httpOptions);
  }

  signup(userDetails: any) {
    return this.http.post('http://localhost:8090/user/signup', userDetails, this.httpOptions);
  }

}
