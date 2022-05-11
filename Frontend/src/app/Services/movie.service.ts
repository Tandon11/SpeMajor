import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Movie} from "../Models/movie.model";

@Injectable({
  providedIn: 'root'
})
export class MovieService {

  httpOptions = {
    headers :new HttpHeaders({
      'Content-Type':'application/json'
    })
  }

  constructor(private http: HttpClient) { }

  addMovie(movie: any) {
   return this.http.post("http://localhost:8090/addMovies", movie, this.httpOptions);
  }

  getMovies() {
    return this.http.get<Movie[]>("http://localhost:8090/getAllMovies");
  }
}
