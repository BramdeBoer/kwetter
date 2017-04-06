import { Component, OnInit } from '@angular/core';
import { User } from "app/user";
import { UserService } from "app/user.service";

@Component({
  selector: 'app-followers',
  templateUrl: './followers.component.html',
  styleUrls: ['./followers.component.css']
})
export class FollowersComponent implements OnInit {

  private users: User[];

  constructor(private userService: UserService) { }

  ngOnInit() {
    this.getUsers();
  }

  public getUsers() {
    this.userService.getFollowers('bramdb').subscribe(users => {
      this.users = users;
    });
  }
}