import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {Show} from "../../Models/show.model";
import {Movie} from "../../Models/movie.model";
import {ShowService} from "../../Services/show.service";
import {MovieService} from "../../Services/movie.service";
import {Theatre} from "../../Models/theatre.model";
import {TheatreService} from "../../Services/theatre.service";
import {LocationService} from "../../Services/location.service";
import {Location} from "../../Models/location.model";

@Component({
  selector: 'app-add-show',
  templateUrl: './add-show.component.html',
  styleUrls: ['./add-show.component.css']
})

export class AddShowComponent implements OnInit {

  shows: Show[] = [];
  movies: Movie[] = [];
  theatres: Theatre[] = [];
  locations: Location[] = [];

  locId: any;
  movId: any;

  constructor(private showService: ShowService, private movieService: MovieService,
              private theatreService: TheatreService, private locationService: LocationService) {}

  form = new FormGroup({
    movieId: new FormControl('', Validators.required),
    locationId: new FormControl('', Validators.required),
    theatreId: new FormControl('', Validators.required),
    showTime: new FormControl('', Validators.required)
  })

  ngOnInit(): void {
    this.getAllShows();
    this.loadMovies();
    this.loadLocations();
  }

  onSubmit() {
    this.showService.addShow(JSON.stringify(this.form.value)).subscribe(
        response => {
          if (response)
            alert("Show Added");
          else
            alert("Something Went Wrong");
          location.reload();
        });
  }

  getAllShows() {
    this.showService.getAllShows().subscribe(
        response => this.shows = response
    );
  }

  loadMovies() {
    this.movieService.getMovies().subscribe(
        response => this.movies = response
    );
  }

  loadLocations() {
    this.locationService.getLocation().subscribe(
        response => this.locations = response
    );
  }

  setLocid(event: any) {
    if (event.target.value)
      this.locId = event.target.value;
  }

  setMovid(event: any) {
    if (event.target.value)
      this.movId = event.target.value;
  }

  getTheatreByLocidAndMovid() {
    this.theatreService.getTheatreById(this.locId, this.movId).subscribe(
        response => {
          this.theatres = response
          console.log(response);
        }
    );
  }
}
