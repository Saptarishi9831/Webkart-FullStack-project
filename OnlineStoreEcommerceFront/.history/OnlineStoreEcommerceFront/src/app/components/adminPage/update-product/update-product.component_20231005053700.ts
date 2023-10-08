import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Category } from 'src/app/class/category';
import { Fourthlevelcategory } from 'src/app/class/fourthlevelcategory';
import { Product } from 'src/app/class/product';
import { Subcategory } from 'src/app/class/subcategory';
import { Subsubcategory } from 'src/app/class/subsubcategory';
import { CategoryService } from 'src/app/service/category.service';
import { FourthLevelCatgeoryService } from 'src/app/service/fourth-level-catgeory.service';
import { ProductService } from 'src/app/service/product.service';
import { SubCategoryService } from 'src/app/service/sub-category.service';
import { SubSubCatgeoryService } from 'src/app/service/sub-sub-catgeory.service';

@Component({
  selector: 'app-update-product',
  templateUrl: './update-product.component.html',
  styleUrls: ['./update-product.component.css']
})
export class UpdateProductComponent implements OnInit {

  productId!: number;
  product: Product = new Product();
  categoryid:number=0;
  categories: Category[] = []; 
  subCategoryId: number = 0;
  subcategories: Subcategory[] = [];
  subsubcategories:Subsubcategory[]=[];
  subSubCategoryId:number=0;
  fourthlevelcategoryId:number=0;
  fourthlevelcategories:Fourthlevelcategory[]=[];
  constructor(private productService: ProductService,private fourthLevelCatgeoryService: FourthLevelCatgeoryService,private categoryService:CategoryService,
    private subCategoryService:SubCategoryService,private subSubCategoryService:SubSubCatgeoryService,
    private route: ActivatedRoute,
    private router: Router) { }

    ngOnInit(): void {
      this.productId = this.route.snapshot.params['id'];
      this.productService.getProductById(this.productId).subscribe(data => {
        this.product = data;
      }, error => console.log(error));
    }
  
    fetchCategories() {
      this.categoryService.getCategoryList().subscribe({
        next: (data: Category[]) => {
          this.categories = data;
          console.log(this.categories);
        },
        error: (error: any) => {
          console.log(error);
        }
      });
    }

    fetchSubCategories()
    {
      this.subCategoryService.getSubCategoryList().subscribe({
        next: (data: Subcategory[]) => {
          this.subcategories = data;
          console.log(this.subcategories);
        },
        error: (error: any) => {
          console.log(error);
        }
      });
    }

    fetchSubSubCategories()
    {
      this.subSubCategoryService.getSubSubCategoryList().subscribe({
        next: (data: Subsubcategory[]) => {
          this.subsubcategories = data;
          console.log(this.subsubcategories);
        },
        error: (error: any) => {
          console.log(error);
        }
      });
    }

    fetchFourthLevelCategories()
    {
      this. fourthLevelCatgeoryService.getFourthLevelCategoryList().subscribe({
        next: (data: Fourthlevelcategory[]) => {
          this.fourthlevelcategories = data;
          console.log(this.fourthlevelcategories);
        },
        error: (error: any) => {
          console.log(error);
        }
      });
    }
  
    onSubmit(){
      console.log('Submitting Product:', this.product);
      this.productService.updateProduct(this.productId, this.product).subscribe(data => {
        window.alert('Product Updated Successfully!');
        this.goToProductList();
      }, error => console.error(error));
    }
  
    goToProductList(){
      this.router.navigate(['/product']);
    }
  }
