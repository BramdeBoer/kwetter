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

  constructor(private tweetService: TweetService) { }

  ngOnInit() {
    this.getTweets();
  }

  public getTweets() {
    this.tweetService.getTimeline('bramdb', 0, 50).subscribe(tweets => {
      this.tweets = tweets;
    });
  }
}
