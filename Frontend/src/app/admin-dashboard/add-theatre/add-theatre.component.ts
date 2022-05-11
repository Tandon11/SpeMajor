import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {Location} from "../../Models/location.model";
import {Movie} from "../../Models/movie.model";
import {TheatreService} from "../../Services/theatre.service";
import {LocationService} from "../../Services/location.service";
import {MovieService} from "../../Services/movie.service";

@Component({
  selector: 'app-add-theatre',
  templateUrl: './add-theatre.component.html',
  styleUrls: ['./add-theatre.component.css']
})
export class AddTheatreComponent implements OnInit {

  locations: Location[] = [];
  movies: Movie[] = [];

  constructor(private theatreService: TheatreService, private locationService: LocationService, private movieService: MovieService) { }

  form = new FormGroup({
    locationId : new FormControl('', Validators.required),
    theatreName : new FormControl('', Validators.required),
    movieID: new FormControl('', Validators.required)
  })

  ngOnInit(): void {
    this.loadLocations();
    this.loadMovies();
  }

  onSubmit() {
    this.theatreService.addTheatre(JSON.stringify(this.form.value)).subscribe(
        response => {
          if(response)
            alert("Theatre Added!!!");
          else
            alert("Something Went Wrong");
          location.reload();
        }
    );}

  loadLocations() {
    this.locationService.getLocation().subscribe(
        response => this.locations = response
    );}

  loadMovies() {
    this.movieService.getMovies().subscribe(
        response => this.movies = response
    );}

}
