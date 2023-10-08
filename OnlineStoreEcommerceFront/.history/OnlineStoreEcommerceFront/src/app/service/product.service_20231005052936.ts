import { Injectable } from '@angular/core';
import { Product } from '../class/product';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Observable } from 'rxjs/internal/Observable';
import { catchError } from 'rxjs/internal/operators/catchError';
import { of } from 'rxjs/internal/observable/of';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  private baseURL = "http://localhost:8888";
  constructor(private httpClient: HttpClient) { }
  
  getProductList(): Observable<Product[]>{
    return this.httpClient.get<Product[]>(`${this.baseURL}/getAllProduct`);
  }

  createProduct(product: Product): Observable<string> {
    return this.httpClient.post<string>(`${this.baseURL}/addProduct`, product);
  }

  getProductById(productId: number): Observable<Product>{
    return this.httpClient.get<Product>(`${this.baseURL}/getProductById/${productId}`);
  }
  
  updateProduct(productId: number, product: Product): Observable<any> {
    const url = `${this.baseURL}/updateProduct/${productId}//${product.fourthlevelcategoryId}/${product.categoryid}/${product.subcategoryId}/${product.subSubCategoryId}`;
    return this.httpClient.put(url, product, { responseType: 'text' }).pipe(
      catchError(error => {
        if (error instanceof HttpErrorResponse && error.status === 200) {
          return of(error.error);
        }
        throw error;
      })
    );
  }
  deleteProduct(productId: number): Observable<string> {
    return this.httpClient.delete<string>(`${this.baseURL}/deleteProduct/${productId}`);
  }
}
