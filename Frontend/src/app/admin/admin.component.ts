import { Component, OnInit } from '@angular/core';
import {AdminService} from "../Services/admin.service";
import {Router} from "@angular/router";
import {FormControl, FormGroup, Validators} from "@angular/forms";

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {

  form = new FormGroup({
    id : new FormControl('', Validators.required),
    password : new FormControl('', Validators.required)
  })

  constructor(private adminService: AdminService,
              private router: Router) { }

  ngOnInit(): void {
  }

  onSubmit() {
    let loginJSOn = JSON.stringify(this.form.value);
    console.log(loginJSOn);
    this.adminService.loginCheck(loginJSOn).subscribe(
      response=>{
        if(response) {
          alert("Successful Login !!!");
          sessionStorage.setItem('authenticatedAdmin', 'Abhishek');
          this.router.navigate(['/admin-dashboard']);
        }

        else
          alert("Login Unsuccessful");
      }
    );}

}
