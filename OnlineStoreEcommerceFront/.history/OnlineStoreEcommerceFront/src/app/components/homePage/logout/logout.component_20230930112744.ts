import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AdminLoginService } from 'src/app/service/admin-login.service';

@Component({
  selector: 'app-logout',
  templateUrl: './logout.component.html',
  styleUrls: ['./logout.component.css']
})
export class LogoutComponent {
constructor(private router: Router, private adminLoginService: AdminLoginService) {
  this.adminLoginService.logout();
  this.router.navigate(['login']);
}
}
