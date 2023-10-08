import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './components/homePage/login/login.component';
import { LogoutComponent } from './components/homePage/logout/logout.component';
import { AdminDashBoardComponent } from './components/homePage/admin-dash-board/admin-dash-board.component';
import { RouteGuardService } from './service/route-guard.service';

const routes: Routes = [
  {path:"login",component:LoginComponent},
  { path: 'logout', component: LogoutComponent },
  { path: 'admindashboard', component:  AdminDashBoardComponent, canActivate: [RouteGuardService] },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
