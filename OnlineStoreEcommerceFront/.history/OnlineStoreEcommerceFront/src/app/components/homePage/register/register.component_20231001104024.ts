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

constructor(private usersService: UsersService) {}

registerUser(): void {
  this.usersService.registerUser(this.users).subscribe(
    response => {
      this.successMessage = response;
    },
    error => {
      this.errorMessage = error;
    }
  );
}
}