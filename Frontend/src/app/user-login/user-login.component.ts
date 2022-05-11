import { Component, OnInit } from '@angular/core';
import {UserService} from "../Services/user.service";
import {Router} from "@angular/router";
import {FormControl, FormGroup, Validators} from "@angular/forms";

@Component({
  selector: 'app-user-login',
  templateUrl: './user-login.component.html',
  styleUrls: ['./user-login.component.css']
})
export class UserLoginComponent implements OnInit {

  form = new FormGroup({
    email : new FormControl('', [Validators.required, Validators.email]),
    password : new FormControl('', Validators.required)
  })

  constructor(private userService: UserService, private router: Router) { }

  ngOnInit(): void {
  }

  onSubmit() {
    var loginJSON = JSON.stringify(this.form.value);
    this.userService.loginCheck(loginJSON).subscribe(
        response => {
          if(response) {
            alert("Login Successful!!");
            var jsonData = JSON.parse(loginJSON);
            this.storeLogin(jsonData['email']);
            this.router.navigate(['/dashboard/']);
          }
          else
            alert("Login Unsuccessful");
        }
    );
  }

  storeLogin(email: any) {
    sessionStorage.setItem("email", JSON.stringify(email));
  }

  checkLogin(){
    if (sessionStorage.length != 0) {
      this.router.navigate(['/']);
    }
  }

}
