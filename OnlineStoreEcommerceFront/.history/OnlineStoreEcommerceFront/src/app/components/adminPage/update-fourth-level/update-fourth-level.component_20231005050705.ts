import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Category } from 'src/app/class/category';
import { Fourthlevelcategory } from 'src/app/class/fourthlevelcategory';
import { Subcategory } from 'src/app/class/subcategory';
import { Subsubcategory } from 'src/app/class/subsubcategory';
import { CategoryService } from 'src/app/service/category.service';
import { FourthLevelCatgeoryService } from 'src/app/service/fourth-level-catgeory.service';
import { SubCategoryService } from 'src/app/service/sub-category.service';
import { SubSubCatgeoryService } from 'src/app/service/sub-sub-catgeory.service';

@Component({
  selector: 'app-update-fourth-level',
  templateUrl: './update-fourth-level.component.html',
  styleUrls: ['./update-fourth-level.component.css']
})
export class UpdateFourthLevelComponent implements OnInit {

  fourthlevelcategoryId!: number;
  fourthlevelcategory: Fourthlevelcategory = new Fourthlevelcategory(0, '',0,0,0);
  categoryid:number=0;
  categories: Category[] = []; 
  subCategoryId: number = 0;
  subcategories: Subcategory[] = [];
  subsubcategories:Subsubcategory[]=[];
  subSubCategoryId:number=0;
  constructor(private fourthLevelCatgeoryService: FourthLevelCatgeoryService,private categoryService:CategoryService,
    private subCategoryService:SubCategoryService,private subSubCategoryService:SubSubCatgeoryService,
    private route: ActivatedRoute,
    private router: Router) { }

    ngOnInit(): void {
      this. fourthlevelcategoryId = this.route.snapshot.params['id'];
  
      this.fourthLevelCatgeoryService.getFourthLevelCategoryById(this.fourthlevelcategoryId).subscribe(data => {
        this.fourthlevelcategory = data;
        this.fetchCategories(); 
        this.fetchSubCategories();
        this.fetchSubSubCategories();
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
          console.log(this.categories);
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
  
    onSubmit(){
      console.log('Submitting fourthlevelcategory:', this.fourthlevelcategory);
      this.fourthLevelCatgeoryService.updateFourthLevelCategory(this.fourthlevelcategoryId, this.fourthlevelcategory).subscribe(data => {
        window.alert('FourthlevelCategory Updated Successfully!');
        this.goToFourthLevelCategoryList();
      }, error => console.error(error));
    }
    
  
    goToFourthLevelCategoryList(){
      this.router.navigate(['/fourthlevelcategory']);
    }
  }
