import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Category } from 'src/app/class/category';
import { Subcategory } from 'src/app/class/subcategory';
import { Subsubcategory } from 'src/app/class/subsubcategory';
import { CategoryService } from 'src/app/service/category.service';
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
  categoryid: number = 0;
  constructor(private categoryService: CategoryService, private subCategoryService: SubCategoryService, private subSubCategoryService: SubSubCatgeoryService, private route: ActivatedRoute) { }


  
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
    this.categoryid = categoryid; // Set categoryid here
    this.subCategoryService.getSubcategoriesByCategoryId(categoryid)
      .subscribe(subcategories => {
        this.subcategories = subcategories;
      });
  }

  onSubcategoryClick(subcategoryId: number): void {
    this.subSubCategoryService.getSubSubCategoriesByCategoryAndSubcategoryId(this.categoryid, subcategoryId)
      .subscribe(data => {
        this.subsubcategories = data;
      });
  }
}
