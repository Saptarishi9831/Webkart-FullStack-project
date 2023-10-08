import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Category } from '../class/category';
import { Observable } from 'rxjs/internal/Observable';
import { Subsubcategory } from '../class/subsubcategory';
import { Subcategory } from '../class/subcategory';

@Injectable({
  providedIn: 'root'
})
export class CategoryService {
  getCategories() {
    throw new Error('Method not implemented.');
  }
  private baseURL = "http://localhost:8888";
  constructor(private httpClient: HttpClient) { }
  
  getCategoryList(): Observable<Category[]>{
    return this.httpClient.get<Category[]>(`${this.baseURL}/getAllCategories`);
  }

  createCategory(category: Category): Observable<Object>{
    return this.httpClient.post(`${this.baseURL}/createCategories`, category);
  }
  getCategoryById(categoryid: number): Observable<Category>{
    return this.httpClient.get<Category>(`${this.baseURL}/getCategoryById/${categoryid}`);
  }
  
  updateCategory(categoryid: number, category:Category): Observable<Object>{
    return this.httpClient.put(`${this.baseURL}/updateCategory/${categoryid}`, category);
  }
  deleteCategory(categoryid: number): Observable<any> {
    return this.httpClient.delete(`${this.baseURL}/deleteCategory/${categoryid}`);
  }
  getSubSubCategoriesByCategoryAndSubcategoryId(categoryid: number, subCategoryId: number): Observable<Subsubcategory[]> {
    return this.httpClient.get<Subsubcategory[]>(`${this.baseURL}/${categoryid}/subcategories/${subCategoryId}/subsubcategories`);
  }
}
