import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/internal/Observable';
import { Fourthlevelcategory } from '../class/fourthlevelcategory';
import { catchError } from 'rxjs/internal/operators/catchError';
import { of } from 'rxjs/internal/observable/of';
import { tap } from 'rxjs/internal/operators/tap';

@Injectable({
  providedIn: 'root'
})
export class FourthLevelCatgeoryService {
  private baseURL = "http://localhost:8888";
  constructor(private httpClient: HttpClient) { }
  
  getFourthLevelCategoryList(): Observable<Fourthlevelcategory[]>{
    return this.httpClient.get<Fourthlevelcategory[]>(`${this.baseURL}/getAllFourthLevelCategories`);
  }

  createFourthLevelCategory(fourthlevelcategory: Fourthlevelcategory): Observable<Object>{
    return this.httpClient.post(`${this.baseURL}/createFourthLevelCategories`, fourthlevelcategory);
  }
  getFourthLevelCategoryById(fourthlevelcategoryId: number): Observable<Fourthlevelcategory>{
    return this.httpClient.get<Fourthlevelcategory>(`${this.baseURL}/getFourthLevelCategoryById/${fourthlevelcategoryId}`);
  }
  
   
  updateFourthLevelCategory(fourthlevelcategoryId: number, fourthlevelcategory: Fourthlevelcategory): Observable<any> {
    const url = `${this.baseURL}/updateFourthLevelCategory/${fourthlevelcategoryId}/${fourthlevelcategory.categoryid}/${fourthlevelcategory.subcategoryId}/${fourthlevelcategory.subSubCategoryId}`;
    return this.httpClient.put(url, fourthlevelcategory, { responseType: 'text' }).pipe(
      catchError(error => {
        if (error instanceof HttpErrorResponse && error.status === 200) {
          return of(error.error);
        }
        throw error;
      })
    );
  }

  deleteFourthLevelCategory(fourthlevelcategoryId: number): Observable<any> {
    return this.httpClient.delete(`${this.baseURL}/deleteFourthLevelCategory/${fourthlevelcategoryId}`);
  }
  
  getFourthLevelCategoriesBySubcategoryId(subSubCategoryId: number): Observable<Fourthlevelcategory[]> {
    const url = `${this.baseURL}/subsubcategories/${subSubCategoryId}/fourthlevelcategories`;
    console.log('API URL:', url);
    return this.httpClient.get<Fourthlevelcategory[]>(url)
        .pipe(
            tap(data => console.log('API Response:', data)), // Log the API response
            catchError(error => {
                console.error('Error fetching fourth level categories:', error);
                throw error;
            })
        );
}

}