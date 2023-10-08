import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AdminLoginService {
  private apiUrl = 'http://localhost:8080';
  constructor(private http: HttpClient) { }
  login(username: string, password: string) {
    const body = { username, password };
    return this.http.post<any>(`${this.apiUrl}/adminLogin`, body);
}
}
