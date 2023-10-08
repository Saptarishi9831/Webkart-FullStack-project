import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';


import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { NavbarComponent } from './components/homePage/navbar/navbar.component';
import { FooterComponent } from './components/homePage/footer/footer.component';
import { LoginComponent } from './components/homePage/login/login.component';
import { HomeComponent } from './components/homePage/home/home.component';
import { LogoutComponent } from './components/adminPage/logout/logout.component';
import { AdminDashBoardComponent } from './components/homePage/admin-dash-board/admin-dash-board.component';

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    FooterComponent,
    LoginComponent,
    HomeComponent,
    LogoutComponent,
    AdminDashBoardComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
