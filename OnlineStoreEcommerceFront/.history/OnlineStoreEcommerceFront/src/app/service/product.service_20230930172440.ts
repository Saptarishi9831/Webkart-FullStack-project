import { Injectable } from '@angular/core';
import { Product } from '../class/product';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/internal/Observable';

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
  
  updateProduct(productId: number, product:Product): Observable<string>{
    return this.httpClient.put<string>(`${this.baseURL}/updateProduct/${productId}`, product);
  }
  deleteProduct(productId: number): Observable<string> {
    return this.httpClient.delete<string>(`${this.baseURL}/deleteProduct/${productId}`);
  }
}
