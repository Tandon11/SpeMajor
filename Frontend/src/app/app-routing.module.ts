import { NgModule } from '@angular/core';
import {RouterModule, Routes} from "@angular/router";
import {AdminComponent} from "./admin/admin.component";
import {AdminDashboardComponent} from "./admin-dashboard/admin-dashboard.component";
import { AddLocationComponent } from './admin-dashboard/add-location/add-location.component';
import {AddMovieComponent} from "./admin-dashboard/add-movie/add-movie.component";
import {AddShowComponent} from "./admin-dashboard/add-show/add-show.component";
import {AddTheatreComponent} from "./admin-dashboard/add-theatre/add-theatre.component";
import {AddSeatComponent} from "./admin-dashboard/add-seat/add-seat.component";
import {HomeComponent} from "./home/home.component";
import {UserRegistrationComponent} from "./user-registration/user-registration.component";
import {UserLoginComponent} from "./user-login/user-login.component";
import {UserDashboardComponent} from "./user-dashboard/user-dashboard.component";
import {MovieListComponent} from "./user-dashboard/movie-list/movie-list.component";
import {MovieBookingComponent} from "./user-dashboard/movie-booking/movie-booking.component";
import {BookingComponent} from "./user-dashboard/booking/booking.component";

const routes : Routes = [
  {
    path:'admin', 
    component:AdminComponent
  },

  {
    path:'admin-dashboard',
     component:AdminDashboardComponent, 
    children:[
      {
        path: '',
        component: AddLocationComponent
      },
      {
        path: 'add-movie',
        component: AddMovieComponent
      },
      {
        path: 'add-show',
        component: AddShowComponent
      },
      {
        path: 'add-theatre',
        component: AddTheatreComponent
      },
      {
        path: 'add-seat',
        component: AddSeatComponent
      }
    ]
  },

  {
    path: '',
    component: HomeComponent
  },

  {
    path: 'signup',
    component: UserRegistrationComponent
  },

  {
    path: 'login',
    component: UserLoginComponent
  },

  {
    path: 'dashboard',
    component: UserDashboardComponent,
    children:[
      {
        path: '',
        component: MovieListComponent
      },
      {
        path: 'movieBooking/:movieId',
        component: MovieBookingComponent
      },
      {
        path: 'Booking',
        component: BookingComponent
      }
    ]
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})

export class AppRoutingModule { }
