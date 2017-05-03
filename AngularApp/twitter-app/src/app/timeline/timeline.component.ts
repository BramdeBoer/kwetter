import { Component, OnInit } from '@angular/core';

import { Tweet } from "app/tweet";
import { User } from "app/user";
import { TweetService } from "app/tweet.service";
import { UserService } from "app/user.service";
import { HttpService } from "app/http.service";

@Component({
  selector: 'app-timeline',
  templateUrl: './timeline.component.html',
  styleUrls: ['./timeline.component.css']
})
export class TimelineComponent implements OnInit {

  private tweets: Tweet[];
  private websocket: WebSocket;

  constructor(private tweetService: TweetService) { 
    this.websocket = new WebSocket(`ws://localhost:8080/kwetter/tweetsocket?username=bramdb`);
    this.initializeWebSocket();
  }

  ngOnInit() {
    this.getTweets();
  }

  initializeWebSocket() {
    this.websocket.onmessage = (event) => this.kweetReceived(event);
  }


  kweetReceived(event) {
    console.log(event.data);
    this.getTweets();
  }

  public createTweet(content) {
    // this.tweetService.create(content, 'bramdb').subscribe(tweet => {
    //   this.getTweets();
    // });

    if (this.websocket.readyState === this.websocket.OPEN) {
      this.websocket.send(content);
    } else {
      this.tweetService.create(content, 'bramdb').subscribe(data => 
        location.reload()
      );
    }
  }

  public getTweets() {
    this.tweetService.getTimeline('bramdb', 0, 50).subscribe(tweets => {
      this.tweets = tweets;
    });
  }
}
