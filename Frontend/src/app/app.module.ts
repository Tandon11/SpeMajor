import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { AppRoutingModule } from './app-routing.module';
import { AdminComponent } from './admin/admin.component';
import { AdminDashboardComponent } from './admin-dashboard/admin-dashboard.component';
import {HttpClientModule} from "@angular/common/http";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import { AddLocationComponent } from './admin-dashboard/add-location/add-location.component';
import { AddMovieComponent } from './admin-dashboard/add-movie/add-movie.component';
import { AddShowComponent } from './admin-dashboard/add-show/add-show.component';
import { AddTheatreComponent } from './admin-dashboard/add-theatre/add-theatre.component';
import { AddSeatComponent } from './admin-dashboard/add-seat/add-seat.component';
import { HomeComponent } from './home/home.component';
import { HomeSectionComponent } from './home-section/home-section.component';
import { HeaderComponent } from './header/header.component';
import { HeaderLoginComponent } from './header-login/header-login.component';
import { UserRegistrationComponent } from './user-registration/user-registration.component';
import { UserLoginComponent } from './user-login/user-login.component';
import { UserDashboardComponent } from './user-dashboard/user-dashboard.component';
import { MovieListComponent } from './user-dashboard/movie-list/movie-list.component';
import { MovieBookingComponent } from './user-dashboard/movie-booking/movie-booking.component';
import { BookingComponent } from './user-dashboard/booking/booking.component';

@NgModule({
  declarations: [
    AppComponent,
    AdminComponent,
    AdminDashboardComponent,
    AddLocationComponent,
    AddMovieComponent,
    AddShowComponent,
    AddTheatreComponent,
    AddSeatComponent,
    HomeComponent,
    HomeSectionComponent,
    HeaderComponent,
    HeaderLoginComponent,
    UserRegistrationComponent,
    UserLoginComponent,
    UserDashboardComponent,
    MovieListComponent,
    MovieBookingComponent,
    BookingComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
