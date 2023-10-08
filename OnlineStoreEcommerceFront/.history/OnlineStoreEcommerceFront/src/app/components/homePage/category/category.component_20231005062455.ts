import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Category } from 'src/app/class/category';
import { Subcategory } from 'src/app/class/subcategory';
import { CategoryService } from 'src/app/service/category.service';

@Component({
  selector: 'app-category',
  templateUrl: './category.component.html',
  styleUrls: ['./category.component.css']
})
export class CategoryComponent implements OnInit{
  categories: Category[] = [];
  subcategories: Subcategory[] = [];
  categoryid: number = 0;

  constructor(private categoryService: CategoryService,  private route: ActivatedRoute) { }

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
}
