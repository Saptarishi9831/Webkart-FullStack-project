import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AdminLoginService } from 'src/app/service/admin-login.service';
import { HardcodedAuthenticationService } from 'src/app/service/hardcoded-authentication.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit{
  username: string = '';
  password: string = '';

  constructor(private adminLoginService: AdminLoginService, private router: Router) {}
  ngOnInit(): void {}

  onSubmit() {
    this.adminLoginService.login(this.username, this.password).subscribe(
      (response) => {
        console.log('Login Successful');
        this.router.navigate(['/home']); 
      },
      (error) => {
        console.error('Login failed', error);
      }
    );
  }
}

