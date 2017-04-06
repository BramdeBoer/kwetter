import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import { Tweet } from './tweet';
import { Headers, Http } from '@angular/http';

import 'rxjs/add/operator/map';
import { API_URL } from './constants';
import { HttpService } from './http.service';

@Injectable()
export class TweetService {

  constructor(private httpService: HttpService) {
  }

  public create(content: String, username: String): Observable<Tweet> {
    return this.httpService.post(`${API_URL}/tweets/${content}/${username}`)
      .map(response => response.json());
  }
  
  public getTimeline(username: String, offset: number, limit: number): Observable<Tweet[]> {
    return this.httpService.get(`${API_URL}/users/${username}/timeline/${offset}/${limit}`)
      .map(response => response.json());
  }

  public getRecentTweets(username: String, offset: number, limit: number): Observable<Tweet[]> {
    return this.httpService.get(`${API_URL}/users/${username}/tweets/${offset}/${limit}`)
      .map(response => response.json());
  }
}