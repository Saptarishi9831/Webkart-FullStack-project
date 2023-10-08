import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Category } from 'src/app/class/category';
import { Fourthlevelcategory } from 'src/app/class/fourthlevelcategory';
import { Product } from 'src/app/class/product';
import { Subcategory } from 'src/app/class/subcategory';
import { Subsubcategory } from 'src/app/class/subsubcategory';
import { ProductService } from 'src/app/service/product.service';

@Component({
  selector: 'app-create-product',
  templateUrl: './create-product.component.html',
  styleUrls: ['./create-product.component.css']
})
export class CreateProductComponent  {
    product: Product = {
    productId: 0,
    productName:'',
    productPrice: 0,
    productSize:'',
    productBrand: '',
    productDescription:'',
    productQuantity: 0,
    productImageUrls:'',
    inStock:  false,
    dateadded:new Date(),
    categoryid: 0,
    subcategoryId:0,
    subSubCategoryId:0,
    fourthlevelcategoryId:0,
  };
  categories: Category[] = []; 
  subcategories:Subcategory[]=[];
  subsubcategories:Subsubcategory[]=[];
  fourthlevelcategories:Fourthlevelcategory[]=[];

  constructor(private productService: ProductService, private router: Router) {}

  saveProduct() {
    this.productService.createProduct(this.product).subscribe(
      (data) => {
        console.log(data);
        this.product = {
        productId: 0,
        productName:'',
        productPrice: 0,
        productSize:'',
        productBrand: '',
        productDescription:'',
        productQuantity: 0,
        productImageUrls:'',
        inStock:  false,
        dateadded:new Date(),
        categoryid: 0,
        subcategoryId:0,
        subSubCategoryId:0,
        fourthlevelcategoryId:0,
        };
        this.goToProductList();
      },
      (error) => console.log(error)
    );
  }

  goToProductList() {
    this.router.navigate(['/product']);
  }

  onSubmit() {
    console.log(this.product);
    this.saveProduct();
    window.alert('Product Added Successfully!');
  }
}

