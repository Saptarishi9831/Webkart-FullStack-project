import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AdminLoginService } from 'src/app/service/admin-login.service';
import { HardcodedAuthenticationService } from 'src/app/service/hardcoded-authentication.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent  {
  mailid: string = '';
  password: string = '';
  errorMessage: string = '';

  constructor(private hardcodedAuthenticationService: HardcodedAuthenticationService, private router: Router) {}

  login(): void {
    this.hardcodedAuthenticationService.login(this.mailid, this.password)
      .subscribe(
        response => {
          this.router.navigate(['/dashboard']);
        },
        error => {
          this.errorMessage = error.error;
        }
      );
  }
}