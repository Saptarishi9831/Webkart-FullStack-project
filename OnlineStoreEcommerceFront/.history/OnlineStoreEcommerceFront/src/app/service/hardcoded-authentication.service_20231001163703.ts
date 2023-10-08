import { Injectable } from '@angular/core';
import { Users } from '../class/users';
import * as bcrypt from 'bcryptjs';

@Injectable({
  providedIn: 'root'
})
export class HardcodedAuthenticationService {
  hashPassword(password: string): string {
    return bcrypt.hashSync(password, 10);
  }


  verifyPassword(plainPassword: string, hashedPassword: string): boolean {
    return bcrypt.compareSync(plainPassword, hashedPassword);
  }
  authenticate(mailid: string, password: string) {
    if(mailid==='' && password===''){
    sessionStorage.setItem('authenticateUser',mailid);
       return true;
  }
    else
        return false;
  }
  isUserLoggedIn(){
    let user=sessionStorage.getItem('authenticateUser');
    return !(user==null);
  }
  logout(){
    sessionStorage.removeItem('authenticateUser');

  }
  constructor()
  {}
}



