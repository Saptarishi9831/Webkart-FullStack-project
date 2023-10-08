import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs/internal/Observable';
import { Category } from 'src/app/class/category';
import { Fourthlevelcategory } from 'src/app/class/fourthlevelcategory';
import { Subcategory } from 'src/app/class/subcategory';
import { Subsubcategory } from 'src/app/class/subsubcategory';
import { CategoryService } from 'src/app/service/category.service';
import { FourthLevelCatgeoryService } from 'src/app/service/fourth-level-catgeory.service';
import { SubCategoryService } from 'src/app/service/sub-category.service';
import { SubSubCatgeoryService } from 'src/app/service/sub-sub-catgeory.service';

@Component({
  selector: 'app-category',
  templateUrl: './category.component.html',
  styleUrls: ['./category.component.css']
})
export class CategoryComponent implements OnInit{
  categories: Category[] = [];
  subcategories: Subcategory[] = [];
  subsubcategories:Subsubcategory[]=[];
  fourthlevelcategories$: Observable<Fourthlevelcategory[]>;
  categoryid: number = 0;
  subcategoryId: number = 0;
  subSubCategoryId:number=0;
  fourthlevelcategoryId: number=0;
  constructor(private categoryService: CategoryService, private subCategoryService: SubCategoryService, private subSubCategoryService: SubSubCatgeoryService,private fourthLevelCategoryService:FourthLevelCatgeoryService, private route: ActivatedRoute) {
  this.fourthlevelcategories$ = new Observable<Fourthlevelcategory[]>
  }
  ngOnInit(): void {
    this.categoryService.getCategoryList().subscribe(
      (categories: Category[]) => {
        this.categories = categories;
      },
      error => {
        console.error('Error fetching categories:', error);
      }
    );
  }

  onCategoryClick(categoryid: number): void {
    this.categoryid = categoryid;
    this.subCategoryService.getSubcategoriesByCategoryId(categoryid)
      .subscribe(subcategories => {
        this.subcategories = subcategories;
      });
  }

  onSubcategoryClick(subcategoryId: number): void {
    console.log('Subcategory ID:', subcategoryId); 
    this.subcategoryId = subcategoryId;
    this.subSubCategoryService.getSubSubCategoriesBySubcategoryId(subcategoryId)
      .subscribe(
        (data: Subsubcategory[]) => {
          console.log('Subsubcategories:', data); 
          this.subsubcategories = data;
        },
        error => {
          console.error('Error fetching subsubcategories:', error);
        }
      );
  }
   
  onSubSubcategoryClick(subSubCategoryId: number): void {
    console.log('SubSubCategory ID:', subSubCategoryId); 
    this.subSubCategoryId = subSubCategoryId;
    const fourthlevelcategoriesObservable$ = this.fourthLevelCategoryService.getFourthLevelCategoriesBySubcategoryId(subSubCategoryId);
    
    fourthlevelcategoriesObservable$.subscribe(
      (data: Fourthlevelcategory[]) => {
        console.log('FourthLevelcategories:', data); 
        this.fourthlevelcategories$ = new Observable<Fourthlevelcategory[]>(observer => {
          observer.next(data);
          observer.complete();
        });
      },
      error => {
        console.error('Error fetching subsubcategories:', error);
      }
    );
  }
}