import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Category } from 'src/app/class/category';
import { CategoryService } from 'src/app/service/category.service';

@Component({
  selector: 'app-category-list',
  templateUrl: './category-list.component.html',
  styleUrls: ['./category-list.component.css']
})
export class CategoryListComponent implements OnInit { 
  categories: Category[] = [];
  category: Category = new Category(0,''); 

  constructor(private categoryService: CategoryService,
    private router: Router) { }

  ngOnInit(): void {
    this.getCategories();
  }

    private getCategories(){
      this.categoryService.getCategoryList().subscribe(data => {
        this.categories = data;
      });
    }

    categoryDetails(categoryid: number){
      this.router.navigate(['category-details', categoryid]);
    }
    
  
    updateCategory(categoryid: number){
      this.router.navigate(['update-category', categoryid]);
    }

    deleteCategory(categoryid: number) {
      this.categoryService.deleteCategory(categoryid).subscribe(
        (data: any) => { 
          console.log(data); 
          this.getCategories();
        },
        (error: any) => { 
          console.error(error); 
        }
      );
    }
  }
    


  
