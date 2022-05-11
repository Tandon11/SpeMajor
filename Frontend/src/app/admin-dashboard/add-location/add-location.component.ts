import { Component, OnInit } from '@angular/core';
import {LocationService} from "../../Services/location.service";
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {Location} from "../../Models/location.model";

@Component({
  selector: 'app-add-location',
  templateUrl: './add-location.component.html',
  styleUrls: ['./add-location.component.css']
})
export class AddLocationComponent implements OnInit {

  form = new FormGroup({
    location_name : new FormControl('', Validators.required)
  })

  constructor(private locationService: LocationService) { }

  location: Location[] = [];

  ngOnInit(): void {
      this.loadLocation();
  }

  onSubmit(){
      console.log(this.form.value);
    this.locationService.addLocation(JSON.stringify(this.form.value))
        .subscribe(
            response=>{
                console.log(response);
              if(response)
                alert("Location Added Successfully");
              else
                alert("Something Went Wrong");
              location.reload();
            }
        );
  }

  loadLocation() {
    this.locationService.getLocation().subscribe(
        response=>{
            console.log("Locations" + response);
          this.location = response;
        }
    );
  }

}
