import { Component, OnInit } from '@angular/core';
import {UserService} from "../Services/user.service";
import {Router} from "@angular/router";
import {AbstractControl, FormControl, FormGroup, Validators} from "@angular/forms";

@Component({
  selector: 'app-user-registration',
  templateUrl: './user-registration.component.html',
  styleUrls: ['./user-registration.component.css']
})
export class UserRegistrationComponent implements OnInit {

  form = new FormGroup({
    email : new FormControl('', [Validators.required, Validators.email]),
    fullname : new FormControl('', Validators.required),
    contactno : new FormControl('', Validators.required),
    password: new FormControl('', Validators.required),
    confPassword : new FormControl('',[Validators.required,this.confirmPasswordCheck])
  })

  constructor(private userService: UserService, private router: Router) { }

  ngOnInit(): void {
    this.checkLogin();
  }

  onSubmit() {
    this.userService.signup(JSON.stringify(this.form.value)).subscribe(
        response => {
          if(response) {
            alert("Sign-Up Successful");
            this.router.navigate(['/login']);
          }
          else {
            alert("Something Went Wrong");
          }
        }
    );}

  storeLogin(email: any) {
    sessionStorage.setItem("email", email);
  }

  checkLogin() {
    if(sessionStorage.length != 0) {
      this.router.navigate(['/']);
    }
  }

  confirmPasswordCheck(control: AbstractControl){
    if (control && control.value !== null || control.value != undefined){
      const cnfPassword = control.value;
      const passControl = control.root.get('password')

      if (passControl){
        const passValue = passControl.value;
        if (passValue !== cnfPassword){
          return {
            isError: true
          }
        }
      }
    }
    return null
  }

}
