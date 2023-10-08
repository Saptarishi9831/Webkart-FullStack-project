import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Category } from 'src/app/class/category';
import { Subcategory } from 'src/app/class/subcategory';
import { Subsubcategory } from 'src/app/class/subsubcategory';
import { SubSubCatgeoryService } from 'src/app/service/sub-sub-catgeory.service';

@Component({
  selector: 'app-create-sub-sub-category',
  templateUrl: './create-sub-sub-category.component.html',
  styleUrls: ['./create-sub-sub-category.component.css']
})
export class CreateSubSubCategoryComponent {

  subsubcategory: Subsubcategory = {
    subSubCategoryName: '',
    subSubCategoryId: 0,
    categoryid: 0,
    subcategoryId:0,
  };
  categories: Category[] = []; 
  subcategories:Subcategory[]=[];
  constructor(private subSubCategoryService:SubSubCatgeoryService, private router: Router) {}

  saveSubSubCategory() {
    this.subSubCategoryService.createSubSubCategory(this.subsubcategory).subscribe(
      (data) => {
        console.log(data);
        this.subsubcategory = {
          subSubCategoryName: '',
          subSubCategoryId: 0,
          categoryid: 0,
          subcategoryId:0,
        };
        this.goToSubSubCategoryList();
      },
      (error) => console.log(error)
    );
  }

  goToSubSubCategoryList() {
    this.router.navigate(['/subsubcategory']);
  }

  onSubmit() {
    console.log(this.subsubcategory);
    this.saveSubSubCategory();
    window.alert('SubSubCategory Added Successfully!');
  }
}
