import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AdminLoginService } from 'src/app/service/admin-login.service';
import { HardcodedAuthenticationService } from 'src/app/service/hardcoded-authentication.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent  {
  mailid: string = '';
  password: string = '';
  result:boolean=false;
  errorMessage:string="";
  constructor(private hardcodedAuthenticationService: HardcodedAuthenticationService, private router: Router) {}

  login():void{
    if(this.hardcodedAuthenticationService.authenticate(this.mailid,this.password))
    {
    this.result=true;
    this.router.navigate(['home',this.mailid]);
    }
    else{
      this.result=false;
      this.errorMessage="Invalid user"
    }
  }

}

