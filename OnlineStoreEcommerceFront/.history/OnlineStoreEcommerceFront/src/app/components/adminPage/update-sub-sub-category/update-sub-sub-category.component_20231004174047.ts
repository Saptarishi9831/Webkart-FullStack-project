import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Category } from 'src/app/class/category';
import { Subcategory } from 'src/app/class/subcategory';
import { Subsubcategory } from 'src/app/class/subsubcategory';
import { CategoryService } from 'src/app/service/category.service';
import { SubCategoryService } from 'src/app/service/sub-category.service';
import { SubSubCatgeoryService } from 'src/app/service/sub-sub-catgeory.service';

@Component({
  selector: 'app-update-sub-sub-category',
  templateUrl: './update-sub-sub-category.component.html',
  styleUrls: ['./update-sub-sub-category.component.css']
})
export class UpdateSubSubCategoryComponent implements OnInit {

  subSubCategoryId!: number;
  subsubcategory: Subsubcategory = new Subsubcategory(0, '',0,0);
  categoryid:number=0;
  categories: Category[] = []; 
  subCategoryId: number = 0;
  subcategories: Subcategory[] = [];
 
  constructor(private subSubCategoryService: SubSubCatgeoryService, private categoryService:CategoryService,
    private subCategoryService:SubCategoryService,
    private route: ActivatedRoute,
    private router: Router) { }

    ngOnInit(): void {
      this.subSubCategoryId = this.route.snapshot.params['id'];
      this.subSubCategoryService.getSubSubCategoryById(this.subSubCategoryId).subscribe(data => {
        this.subsubcategory = data;
        this.fetchCategories(); 
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
  
    onSubmit(){
      console.log('Submitting subsubcategory:', this.subsubcategory);
      this.subSubCategoryService.updateSubSubCategory(this.subSubCategoryId, this.subsubcategory).subscribe(data => {
        window.alert('SubSubCategory Updated Successfully!');
        this.goToSubSubCategoryList();
      }, error => console.error(error));
    }
    
  
    goToSubSubCategoryList(){
      this.router.navigate(['/subsubcategory']);
    }
    updateCategoryIds(subSubCategoryId: number, categoryId: number): void {
      this.subSubCategoryService.setCategoryidToSubSubCategory(subSubCategoryId, categoryId)
        .subscribe(
          response => {
            console.log(response); 
          },
          error => {
            console.error(error); 
          }
        );
    }


  }