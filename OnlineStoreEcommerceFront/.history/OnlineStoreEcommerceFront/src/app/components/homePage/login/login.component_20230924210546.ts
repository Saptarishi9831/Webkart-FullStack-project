import { Component } from '@angular/core';
import { HardcodedAuthenticationService } from 'src/app/service/hardcoded-authentication.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  username: string = '';
  password: string = '';
  loginError: string = '';

  constructor(private hardcodedAuthenticationService: HardcodedAuthenticationService) {}

  login() {
    this.hardcodedAuthenticationService.login(this.username, this.password).subscribe(
      (response) => {
        console.log('Login successful:', response);
      },
      (error) => {
        this.loginError = 'Invalid username or password';
        console.error('Login failed:', error);
      }
    );
  }
}

