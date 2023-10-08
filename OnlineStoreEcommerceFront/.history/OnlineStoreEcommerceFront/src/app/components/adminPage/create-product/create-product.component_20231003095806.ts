import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Product } from 'src/app/class/product';
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
    dateadded:new Date()
  };

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
        dateadded:new Date()
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

