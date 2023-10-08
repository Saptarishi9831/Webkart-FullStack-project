import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Fourthlevelcategory } from 'src/app/class/fourthlevelcategory';
import { FourthLevelCatgeoryService } from 'src/app/service/fourth-level-catgeory.service';

@Component({
  selector: 'app-update-fourth-level',
  templateUrl: './update-fourth-level.component.html',
  styleUrls: ['./update-fourth-level.component.css']
})
export class UpdateFourthLevelComponent implements OnInit {

  fourthlevelcategoryId!: number;
  fourthlevelcategory: Fourthlevelcategory = new Fourthlevelcategory(0, '');
  constructor(private fourthLevelCatgeoryService: FourthLevelCatgeoryService,
    private route: ActivatedRoute,
    private router: Router) { }

    ngOnInit(): void {
      this. fourthlevelcategoryId = this.route.snapshot.params['id'];
  
      this.fourthLevelCatgeoryService.getFourthLevelCategoryById(this.fourthlevelcategoryId).subscribe(data => {
        this.fourthlevelcategory = data;
      }, error => console.log(error));
    }
  
    onSubmit(){
      console.log('Submitting FourthLevelCategory:', this.fourthlevelcategory);
      this.fourthLevelCatgeoryService.updateFourthLevelCategory(this.fourthlevelcategoryId, this.fourthlevelcategory).subscribe( data =>{
        window.alert('FourthLevelCategory Updated Successfully!');
        this.goToFourthLevelCategoryList();
        
      }
      , error => console.log(error));


    }
  
    goToFourthLevelCategoryList(){
      this.router.navigate(['/fourthlevelcategory']);
    }
  }
