import { Injectable } from '@angular/core';
import { CanActivate, Router } from '@angular/router';
import { AdminLoginService } from './admin-login.service';

@Injectable({
  providedIn: 'root'
})
export class RouteGuardService implements CanActivate {

  constructor(private router: Router, private adminLoginService: AdminLoginService) {}

  canActivate(): boolean {
    if (this.adminLoginService.isAdminLoggedIn()) {
      return true;
    }
    this.router.navigate(['/admin/login']);
    return false;
  }
}
