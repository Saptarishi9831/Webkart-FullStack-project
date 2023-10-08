import { Component, OnInit } from '@angular/core';
import { Subcategory } from 'src/app/class/subcategory';
import { SubCategoryService } from 'src/app/service/sub-category.service';

@Component({
  selector: 'app-subcategory',
  templateUrl: './subcategory.component.html',
  styleUrls: ['./subcategory.component.css']
})
export class SubcategoryComponent  implements OnInit {

  subcategories: Subcategory[] = [];
  selectedCategoryId: number = 1; 
  constructor(private subCategoryService: SubCategoryService) { }

  ngOnInit(): void {
    this.loadSubcategories();
  }

  loadSubcategories(): void {
    this.subCategoryService.getSubcategoriesByCategoryId(this.selectedCategoryId).subscribe(
      (subcategories: Subcategory[]) => {
        this.subcategories = subcategories;
      },
      error => {
        console.error('Error fetching subcategories:', error);
      }
    );
  }
}{

}
