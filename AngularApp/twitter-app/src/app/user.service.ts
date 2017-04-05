import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import { User } from './user';
import { Headers, Http } from '@angular/http';

import 'rxjs/add/operator/map';
import { API_URL } from './constants';
import { HttpService } from './http.service';

@Injectable()
export class UserService {

  constructor(private httpService: HttpService) {
  }
  
  public getByUsername(username: String): Observable<User> {
    return this.httpService.get(`${API_URL}/users/${username}`)
      .map(response => response.json());
  }
}