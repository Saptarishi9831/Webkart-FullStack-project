import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/internal/Observable';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  private baseUrl = 'http://localhost:8888';

  constructor(private http: HttpClient) {}

  login(mailid: string, password: string): Observable<any> {
    return this.http.post<any>(`${this.baseUrl}/login`, { mailid, password });
  }
}

