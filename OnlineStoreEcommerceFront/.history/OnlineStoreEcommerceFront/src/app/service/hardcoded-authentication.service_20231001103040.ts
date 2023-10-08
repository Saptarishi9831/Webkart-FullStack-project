import { Injectable } from '@angular/core';
import { Users } from '../class/users';

@Injectable({
  providedIn: 'root'
})
export class HardcodedAuthenticationService {

  private users: Users[] = [];

  authenticateUser(user: Users): boolean {
    const matchedUser = this.users.find(u => u.mailid === user.mailid && u.password === user.password);
    return !!matchedUser;
  }
}