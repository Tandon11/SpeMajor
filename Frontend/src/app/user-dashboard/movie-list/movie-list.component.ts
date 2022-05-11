import { Component, OnInit } from '@angular/core';
import {Movie} from "../../Models/movie.model";
import {Seat} from "../../Models/seat.model";
import {MovieService} from "../../Services/movie.service";
import {SeatService} from "../../Services/seat.service";

@Component({
  selector: 'app-movie-list',
  templateUrl: './movie-list.component.html',
  styleUrls: ['./movie-list.component.css']
})
export class MovieListComponent implements OnInit {

  movies: Movie[] = [];
  seats: Seat[] = [];

  constructor(private movieService: MovieService,
              private seatService: SeatService,) { }

  ngOnInit(): void {
    this.loadMovies();
    this.loadSeats();
  }

  loadMovies() {
    this.movieService.getMovies().subscribe(
        response => this.movies = response
    );
  }

  loadSeats() {
    this.seatService.getSeats().subscribe(
        response => this.seats = response
    );
  }

  // set(image: any) {
  //   console.log(image);
  // }

}
