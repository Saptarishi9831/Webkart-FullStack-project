import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/internal/Observable';
import { Subsubcategory } from '../class/subsubcategory';

@Injectable({
  providedIn: 'root'
})
export class SubSubCatgeoryService {
  private baseURL = "http://localhost:8888";
  constructor(private httpClient: HttpClient) { }
  
  getSubSubCategoryList(): Observable<Subsubcategory[]>{
    return this.httpClient.get<Subsubcategory[]>(`${this.baseURL}/getAllSubSubCategories`);
  }

  createSubSubCategory(subsubcategory: Subsubcategory): Observable<Object>{
    return this.httpClient.post(`${this.baseURL}/createSubSubCategories`, subsubcategory);
  }
  getSubSubCategoryById(subSubCategoryId: number): Observable<Subsubcategory>{
    return this.httpClient.get<Subsubcategory>(`${this.baseURL}/getSubSubCategoryById/${subSubCategoryId}`);
  }
  
  updateSubSubCategory(subSubCategoryId: number, subsubcategory: Subsubcategory): Observable<Object>{
    return this.httpClient.put(`${this.baseURL}/updateSubSubCategory/${subSubCategoryId}`, subsubcategory);
  }
  deleteSubSubCategory(subSubCategoryId: number): Observable<any> {
    return this.httpClient.delete(`${this.baseURL}/deleteSubSubCategory/${subSubCategoryId}`);
  }
  setCategoryidToSubSubCategory(subSubCategoryId: number, categoryid: number): Observable<any> {
    const url = `${this.baseURL}/setCategoryidToSubSubCategory/${subSubCategoryId}/${categoryid}`;
    return this.httpClient.put(url, null); 
  }
}
