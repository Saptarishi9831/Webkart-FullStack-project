import { Component } from '@angular/core';
import { OnInit } from '@angular/core';
import { Admin } from 'src/app/admin';
import { AdminRegistrationService } from 'src/app/service/admin-registration.service';
@Component({
  selector: 'app-admin-registration',
  templateUrl: './admin-registration.component.html',
  styleUrls: ['./admin-registration.component.css']
})
export class AdminRegistrationComponent  {
  username: string = '';
  password: string = '';
  errorMessage: string = '';

  constructor(private adminRegistrationService: AdminRegistrationService) {}

  registerAdmin(): void {
    this.adminRegistrationService.registerAdmin(this.username, this.password)
      .subscribe(
        response => {
          console.log('Admin registered successfully:', response);
        },
        error => {
          console.error('Registration Error:', error);
          this.errorMessage = error.error;
        }
      );
  }
}
  
