import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/internal/Observable';
import { Users } from '../class/users';

@Injectable({
  providedIn: 'root'
})
export class UsersService {

  private baseUrl = 'http://localhost:8888/register';
  constructor(private httpClient: HttpClient) { }
  registerUser(users: Users): Observable<string> {
    return this.httpClient.post<string>(this.baseUrl, users);
  }


}
