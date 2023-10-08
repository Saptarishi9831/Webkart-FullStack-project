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
username: string = '';
password: string = '';
errorMessage: string = '';

constructor(private router: Router, private adminLoginService: AdminLoginService) {}

login(): void {
  this.adminLoginService.authenticate(this.username, this.password)
    .subscribe(
      response => {
        console.log(response); 
        this.router.navigate(['/admin/dashboard']);
      },
      error => {
        console.error(error); 
        this.errorMessage = 'Invalid username or password';
      }
    );
}
}