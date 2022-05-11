import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {MovieService} from "../../Services/movie.service";

@Component({
  selector: 'app-add-movie',
  templateUrl: './add-movie.component.html',
  styleUrls: ['./add-movie.component.css']
})
export class AddMovieComponent implements OnInit {

  form = new FormGroup({
    movieName : new FormControl('', Validators.required),
    genre : new FormControl('', Validators.required),
    summary : new FormControl('', Validators.required),
    review : new FormControl('', Validators.required),
    image : new FormControl('', Validators.required),
  })

  constructor(private movieService: MovieService) { }

  ngOnInit(): void {
  }

  onSubmit() {
    console.log(this.form.value);
    this.movieService.addMovie(JSON.stringify(this.form.value)).subscribe(
        response=>{
          if(response)
            alert("Movie Added Successfully");
          else
            alert("Something Went Wrong");
          location.reload();
        }
    );}
}
