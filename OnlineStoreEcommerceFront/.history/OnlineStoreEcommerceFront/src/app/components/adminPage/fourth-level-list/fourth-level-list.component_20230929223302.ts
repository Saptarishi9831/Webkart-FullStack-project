import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Fourthlevelcategory } from 'src/app/class/fourthlevelcategory';
import { FourthLevelCatgeoryService } from 'src/app/service/fourth-level-catgeory.service';

@Component({
  selector: 'app-fourth-level-list',
  templateUrl: './fourth-level-list.component.html',
  styleUrls: ['./fourth-level-list.component.css']
})
export class FourthLevelListComponent implements OnInit { 
  fourthlevelcategories: Fourthlevelcategory[] = [];
  fourthlevelcategory: Fourthlevelcategory = new Fourthlevelcategory(0,''); 

  constructor(private fourthLevelCatgeoryService: FourthLevelCatgeoryService,
    private router: Router) { }

  ngOnInit(): void {
    this.getFourthLevelCategories();
  }

    private getFourthLevelCategories(){
      this.fourthLevelCatgeoryService.getFourthLevelCategoryList().subscribe(data => {
        this. fourthlevelcategories = data;
      });
    }

    fourthLevelCategoryDetails(fourthlevelcategoryId: number){
      this.router.navigate(['fourth-level-category-details', fourthlevelcategoryId]);
    }
    
  
    updateFourthLevelCategory(fourthlevelcategoryId: number){
      this.router.navigate(['update-fourth-level', fourthlevelcategoryId]);
    }

    deleteFourthLevelCategory(fourthlevelcategoryId: number) {
      this.fourthLevelCatgeoryService.deleteFourthLevelCategory(fourthlevelcategoryId).subscribe(
        (data: any) => { 
          console.log(data); 
          this.getFourthLevelCategories();
        },
        (error: any) => { 
          console.error(error); 
        }
      );
    }
  }
