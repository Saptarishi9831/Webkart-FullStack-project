import { Injectable } from '@angular/core';
import { CanActivate, Router } from '@angular/router';
import { AdminLoginService } from './admin-login.service';
import { HardcodedAuthenticationService } from './hardcoded-authentication.service';

@Injectable({
  providedIn: 'root'
})
export class RouteGuardService implements CanActivate {

  constructor(private hardcodedAuthenticationService:HardcodedAuthenticationService, private router: Router) {}

  canActivate(): boolean {
    if (this. hardcodedAuthenticationService.isAuthenticated()) {
      return true;
    } else {
      this.router.navigate(['/login']); 
      return false;
    }
  }
}

