import { Component, OnInit } from '@angular/core';
import { Tweet } from "app/tweet";
import { TweetService } from "app/tweet.service";

@Component({
  selector: 'app-usertweets',
  templateUrl: './usertweets.component.html',
  styleUrls: ['./usertweets.component.css']
})
export class UsertweetsComponent implements OnInit {
  private tweets: Tweet[];

  constructor(private tweetService: TweetService) { }

  ngOnInit() {
    this.getTweets();
  }

  public getTweets() {
    this.tweetService.getRecentTweets('bramdb', 0, 50).subscribe(tweets => {
      this.tweets = tweets;
    });
  }
}
