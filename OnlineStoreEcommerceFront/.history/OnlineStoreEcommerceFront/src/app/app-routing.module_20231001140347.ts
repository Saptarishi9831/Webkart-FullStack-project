import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './components/homePage/login/login.component';

import { RegisterComponent } from './components/homePage/register/register.component';

const routes: Routes = [
  {path:"login",component:LoginComponent},
  { path:'register', component: RegisterComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
