import { Component } from '@angular/core';
import { Users } from 'src/app/class/users';
import { HardcodedAuthenticationService } from 'src/app/service/hardcoded-authentication.service';
import { UsersService } from 'src/app/service/users.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent  {

users: Users = new Users(0,'','','','','');
successMessage: string = '';
errorMessage: string = '';

constructor(private usersService: UsersService, private hardcodedAuthenticationService: HardcodedAuthenticationService) {}

registerUser(): void {
  if (this.hardcodedAuthenticationService.authenticateUser(this.users)) {
    this.usersService.registerUser(this.users).subscribe(
      response => {
        this.successMessage = response;
      },
      error => {
        this.errorMessage = error;
      }
    );
  } else {
    this.errorMessage = 'Authentication failed. Please check your credentials.';
  }
}
}