import { Injectable } from '@angular/core';
import { Users } from '../class/users';

@Injectable({
  providedIn: 'root'
})
export class HardcodedAuthenticationService {
   constructor(){}

   isUserLoggedIn(){
    let user = sessionStorage.getItem('authenticateduser');
    return !(user==null);
  }

  logout(){
    sessionStorage.removeItem('authenticateduser');
  }

}