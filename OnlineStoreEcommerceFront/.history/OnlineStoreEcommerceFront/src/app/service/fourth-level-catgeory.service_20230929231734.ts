import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/internal/Observable';
import { Fourthlevelcategory } from '../class/fourthlevelcategory';

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
  
  updateFourthLevelCategory(fourthlevelcategoryId: number, fourthlevelcategory: Fourthlevelcategory): Observable<Object>{
    return this.httpClient.put(`${this.baseURL}/updateFourthLevelCategory/${fourthlevelcategoryId}`,  fourthlevelcategory);
  }
  deleteFourthLevelCategory(fourthlevelcategoryId: number): Observable<any> {
    return this.httpClient.delete(`${this.baseURL}/deleteFourthLevelCategory/${fourthlevelcategoryId}`);
  }
}