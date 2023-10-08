import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/internal/Observable';
import { Subsubcategory } from '../class/subsubcategory';
import { catchError } from 'rxjs/internal/operators/catchError';
import { of } from 'rxjs/internal/observable/of';

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
  
  updateSubSubCategory(subSubCategoryId: number, subsubcategory: Subsubcategory): Observable<any> {
    const url = `${this.baseURL}/updateSubSubCategory/${subSubCategoryId}`;
    return this.httpClient.put(url, subsubcategory, { responseType: 'text' }).pipe(
      catchError(error => {
        if (error instanceof HttpErrorResponse && error.status === 200) {
          return of(error.error);
        }
        throw error;
      })
    );
  }
  deleteSubSubCategory(subSubCategoryId: number): Observable<any> {
    return this.httpClient.delete(`${this.baseURL}/deleteSubSubCategory/${subSubCategoryId}`);
  }
  setCategoryidToSubSubCategory(subSubCategoryId: number, categoryid: number): Observable<any> {
    const url = `${this.baseURL}/setCategoryidToSubSubCategory/${subSubCategoryId}/${categoryid}`;
    return this.httpClient.put(url, null); 
  }
  setsubcategoryidToSubSubCategory(subSubCategoryId: number,subcategoryid:number): Observable<any>
  {
    const url = `${this.baseURL}/setsubcategoryidToSubSubCategory/${subSubCategoryId}/${subcategoryid}`;
    return this.httpClient.put(url, null); 
  }
}
