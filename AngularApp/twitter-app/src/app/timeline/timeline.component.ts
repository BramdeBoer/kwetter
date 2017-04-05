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
  private user: User;

  constructor(private tweetService: TweetService,
    private userService: UserService) { }

  ngOnInit() {
    this.user = {id: 1,
      username: 'bramdb'};
    this.getTweets();
  }

  public getTweets() {
    this.tweetService.getTimeline(this.user.username, 0, 50).subscribe(tweets => {
      this.tweets = tweets;
    });
  }
}
