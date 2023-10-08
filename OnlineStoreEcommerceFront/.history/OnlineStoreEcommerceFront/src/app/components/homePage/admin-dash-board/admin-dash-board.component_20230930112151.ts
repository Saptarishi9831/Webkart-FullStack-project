import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AdminLoginService } from 'src/app/service/admin-login.service';

@Component({
  selector: 'app-admin-dash-board',
  templateUrl: './admin-dash-board.component.html',
  styleUrls: ['./admin-dash-board.component.css']
})
export class AdminDashBoardComponent{
 constructor(private router: Router, public adminLoginService: AdminLoginService) {}

logout(): void {
  this.adminLoginService.logout();
  this.router.navigate(['/admin/login']);
}
}