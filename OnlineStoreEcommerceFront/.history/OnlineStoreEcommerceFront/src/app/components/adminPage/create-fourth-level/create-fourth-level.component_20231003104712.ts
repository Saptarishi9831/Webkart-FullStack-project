import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Fourthlevelcategory } from 'src/app/class/fourthlevelcategory';
import { FourthLevelCatgeoryService } from 'src/app/service/fourth-level-catgeory.service';

@Component({
  selector: 'app-create-fourth-level',
  templateUrl: './create-fourth-level.component.html',
  styleUrls: ['./create-fourth-level.component.css']
})
export class CreateFourthLevelComponent  {
  fourthlevelcategory:Fourthlevelcategory = {
    fourthlevelcategoryname: '',
    fourthlevelcategoryId: 0
  };

  constructor(private fourthLevelCatgeoryService: FourthLevelCatgeoryService, private router: Router) {}

  saveFourthLevelCategory() {
    this.fourthLevelCatgeoryService.createFourthLevelCategory(this.fourthlevelcategory).subscribe(
      (data) => {
        console.log(data);
        this.fourthlevelcategory = {
          fourthlevelcategoryname: '',
          fourthlevelcategoryId: 0
        };
        this.goToFourthLevelCategoryList();
      },
      (error) => console.log(error)
    );
  }

  goToFourthLevelCategoryList() {
    this.router.navigate(['/fourthlevelcategory']);
  }

  onSubmit() {
    console.log(this.fourthlevelcategory);
    this.saveFourthLevelCategory();
    window.alert('FourthLevelCategory Added Successfully!');
  }
}

