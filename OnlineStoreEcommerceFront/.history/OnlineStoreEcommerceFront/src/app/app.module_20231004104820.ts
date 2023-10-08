import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { AdminRegistrationComponent } from './components/homePage/admin-registration/admin-registration.component';
import { HttpClientModule } from '@angular/common/http';
import { NavbarComponent } from './components/homePage/navbar/navbar.component';
import { FooterComponent } from './components/homePage/footer/footer.component';
import { LoginComponent } from './components/homePage/login/login.component';
import { HomeComponent } from './components/homePage/home/home.component';

import { LogoutComponent } from './components/homePage/logout/logout.component';
import { RegisterComponent } from './components/homePage/register/register.component';
import { MenuComponent } from './components/homePage/menu/menu.component';
import { CategoryListComponent } from './components/adminPage/category-list/category-list.component';
import { CreateCategoryComponent } from './components/adminPage/create-category/create-category.component';
import { UpdateCategoryComponent } from './components/adminPage/update-category/update-category.component';
import { SubCategoryListComponent } from './components/adminPage/sub-category-list/sub-category-list.component';
import { CreateSubCategoryComponent } from './components/adminPage/create-sub-category/create-sub-category.component';
import { UpdateSubCategoryComponent } from './components/adminPage/update-sub-category/update-sub-category.component';
import { SubSubCategoryListComponent } from './components/adminPage/sub-sub-category-list/sub-sub-category-list.component';
import { CreateSubSubCategoryComponent } from './components/adminPage/create-sub-sub-category/create-sub-sub-category.component';
import { UpdateSubSubCategoryComponent } from './components/adminPage/update-sub-sub-category/update-sub-sub-category.component';
import { FourthLevelListComponent } from './components/adminPage/fourth-level-list/fourth-level-list.component';
import { CreateFourthLevelComponent } from './components/adminPage/create-fourth-level/create-fourth-level.component';
import { UpdateFourthLevelComponent } from './components/adminPage/update-fourth-level/update-fourth-level.component';
import { ProductListComponent } from './components/adminPage/product-list/product-list.component';
import { CreateProductComponent } from './components/adminPage/create-product/create-product.component';
import { UpdateProductComponent } from './components/adminPage/update-product/update-product.component';
import { ProductDetailsComponent } from './components/adminPage/product-details/product-details.component';

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    FooterComponent,
    LoginComponent,
    HomeComponent,
    AdminRegistrationComponent,
    AdminDashBoardComponent,
    LogoutComponent,
    RegisterComponent,
    MenuComponent,
    CategoryListComponent,
    CreateCategoryComponent,
    UpdateCategoryComponent,
    SubCategoryListComponent,
    CreateSubCategoryComponent,
    UpdateSubCategoryComponent,
    SubSubCategoryListComponent,
    CreateSubSubCategoryComponent,
    UpdateSubSubCategoryComponent,
    FourthLevelListComponent,
    CreateFourthLevelComponent,
    UpdateFourthLevelComponent,
    ProductListComponent,
    CreateProductComponent,
    UpdateProductComponent,
    ProductDetailsComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    ReactiveFormsModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
