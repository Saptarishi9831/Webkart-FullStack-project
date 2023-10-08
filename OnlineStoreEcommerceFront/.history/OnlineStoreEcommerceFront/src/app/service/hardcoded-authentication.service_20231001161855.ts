import { Injectable } from '@angular/core';
import { Users } from '../class/users';

@Injectable({
  providedIn: 'root'
})
export class HardcodedAuthenticationService {
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



