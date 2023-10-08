import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AdminLoginService } from 'src/app/service/admin-login.service';
import { HardcodedAuthenticationService } from 'src/app/service/hardcoded-authentication.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent  {
  loginForm: FormGroup;
  errorMessage: string = '';

  constructor(
    private adminLoginService: AdminLoginService,
    private router: Router,
    private formBuilder: FormBuilder
  ) {
    this.loginForm = this.formBuilder.group({
      username: ['', Validators.required],
      password: ['', Validators.required]
    });
  }

  login(): void {
    if (this.loginForm.valid) {
      this.adminLoginService.login(this.loginForm.value)
        .subscribe(
          response => {
            if (response && response.error) {
              this.errorMessage = response.error;
            } else {
              this.router.navigate(['/admindashboard']);
            }
          },
          error => {
            this.errorMessage = 'An error occurred during login.';
            console.error('Login Error:', error);
          }
        );
    }
  }
}


