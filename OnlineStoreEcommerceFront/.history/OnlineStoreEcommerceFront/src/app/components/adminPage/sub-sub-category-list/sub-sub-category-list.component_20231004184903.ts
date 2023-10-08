import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Subsubcategory } from 'src/app/class/subsubcategory';
import { SubSubCatgeoryService } from 'src/app/service/sub-sub-catgeory.service';

@Component({
  selector: 'app-sub-sub-category-list',
  templateUrl: './sub-sub-category-list.component.html',
  styleUrls: ['./sub-sub-category-list.component.css']
})
export class SubSubCategoryListComponent implements OnInit { 
  subsubcategories: Subsubcategory[] = [];
  subsubcategory: Subsubcategory = new Subsubcategory(0,'',0,0); 

  constructor(private subSubCatgeoryService: SubSubCatgeoryService,
    private router: Router) { }

  ngOnInit(): void {
    this.getSubSubCategories();
  }

    private getSubSubCategories(){
      this.subSubCatgeoryService.getSubSubCategoryList().subscribe(data => {
        this.subsubcategories = data;
      });
    }

    subSubcategoryDetails(subSubCategoryId: number){
      this.router.navigate(['sub-sub-category-details', subSubCategoryId]);
    }
    
  
    updateSubSubCategory(subSubCategoryId: number){
      this.router.navigate(['update-sub-sub-category', subSubCategoryId]);
    }

    deleteSubSubCategory(subSubCategoryId: number) {
      this.subSubCatgeoryService.deleteSubSubCategory(subSubCategoryId).subscribe(
        (data: any) => { 
          console.log(data); 
          this.getSubSubCategories();
        },
        (error: any) => { 
          console.error(error); 
        }
      );
    }
  }
    