import { Component, OnInit } from '@angular/core';
import { User } from "app/user";
import { UserService } from "app/user.service";
import { ActivatedRoute, Params, Route, Router } from "@angular/router";

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {
  user: User;

  constructor(private userService: UserService, private route: ActivatedRoute) {
  }

  ngOnInit() {
    this.route.queryParams
      .map(params => params['username'])
      .subscribe(username => this.getAccount(username));
  }

  private getAccount(username: string) {
    if(!username){
      username = 'bramdb';
    }
    this.userService.getByUsername(username).subscribe(user => {
      this.user = user;
    });
  }
}
