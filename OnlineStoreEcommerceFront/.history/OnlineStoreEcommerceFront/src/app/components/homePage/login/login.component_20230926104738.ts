import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AdminLoginService } from 'src/app/service/admin-login.service';
import { HardcodedAuthenticationService } from 'src/app/service/hardcoded-authentication.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  username: string = '';
  password: string = '';

  constructor(private adminLoginService: AdminLoginService, private router: Router) {}

  onSubmit() {
    this.adminLoginService.login(this.username, this.password).subscribe(
      (response) => {
        // Handle a successful login response here
        console.log('Login Successful');
        this.router.navigate(['/home']); 
      },
      (error) => {
        // Handle an error response (e.g., invalid credentials)
        console.error('Login failed', error);
      }
    );
  }
}

