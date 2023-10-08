import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/internal/Observable';

@Injectable({
  providedIn: 'root'
})
export class AdminLoginService {
  private baseUrl = 'http://localhost:8888';

  constructor(private http: HttpClient) {}

  authenticate(username: string, password: string): Observable<string> {
    return this.http.post<string>(`${this.baseUrl}/adminLogin`, { username, password });
  }
  logout(): void {
    sessionStorage.removeItem('authenticatedAdmin');
  }
  isAdminLoggedIn(): boolean {
    return !!sessionStorage.getItem('authenticatedAdmin');
  }
}


