import { Component, OnInit } from '@angular/core';
import { TweetService } from "app/tweet.service";

@Component({
  selector: 'app-newtweet',
  templateUrl: './newtweet.component.html',
  styleUrls: ['./newtweet.component.css']
})
export class NewtweetComponent implements OnInit {

  constructor(private tweetService: TweetService) { }

  ngOnInit() {
  }


  public createTweet(content) {
    this.tweetService.create(content, 'bramdb').subscribe(tweet => {
      console.log(tweet);
      location.reload();
    });
  }
}