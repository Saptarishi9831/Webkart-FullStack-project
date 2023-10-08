import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/internal/Observable';
import { tap } from 'rxjs/internal/operators/tap';


@Injectable({
  providedIn: 'root'
})
export class AdminLoginService {
  private baseUrl = 'http://localhost:8888';

  constructor(private http: HttpClient) {}

  login(admin: any): Observable<any> {
    return this.http.post<any>(`${this.baseUrl}/adminLogin`, admin).pipe(
      tap(response => {
        console.log('Login Response:', response);
      })
    );
  }

}

