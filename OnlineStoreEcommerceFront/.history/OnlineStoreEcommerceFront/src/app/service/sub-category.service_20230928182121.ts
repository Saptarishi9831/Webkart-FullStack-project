import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

import { Subcategory } from '../class/subcategory';
import { Observable } from 'rxjs/internal/Observable';


@Injectable({
  providedIn: 'root'
})
export class SubCategoryService {

  private baseURL = "http://localhost:8888";
  constructor(private httpClient: HttpClient) { }
  
  getSubCategoryList(): Observable<Subcategory[]>{
    return this.httpClient.get<Subcategory[]>(`${this.baseURL}/getAllSubCategories`);
  }

  createSubCategory(subcategory: Subcategory): Observable<Object>{
    return this.httpClient.post(`${this.baseURL}/createSubCategories`, subcategory);
  }
  getSubCategoryById(subcategoryId: number): Observable<Subcategory>{
    return this.httpClient.get<Subcategory>(`${this.baseURL}/getSubCategoryById/${subcategoryId}`);
  }
  
  updateSubCategory(subcategoryId: number, subcategory:Subcategory): Observable<Object>{
    return this.httpClient.put(`${this.baseURL}/updateSubCategory/${subcategoryId}`, subcategory);
  }
  deleteSubCategory(subcategoryId: number): Observable<any> {
    return this.httpClient.delete(`${this.baseURL}/deleteSubCategory/${subcategoryId}`);
  }
  setCategoryidToSubCategory(subCategoryId: number, categoryid: number): Observable<any> {
    const url = `${this.baseURL}/setCategoryidToSubCategory/${subCategoryId}/${categoryid}`;
    return this.httpClient.put(url, null); 
  }
}

