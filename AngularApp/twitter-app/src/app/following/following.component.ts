import { Component, OnInit } from '@angular/core';
import { UserService } from "app/user.service";
import { User } from "app/user";

@Component({
  selector: 'app-following',
  templateUrl: './following.component.html',
  styleUrls: ['./following.component.css']
})
export class FollowingComponent implements OnInit {

  private users: User[];

  constructor(private userService: UserService) { }

  ngOnInit() {
    this.getUsers();
  }

  public getUsers() {
    this.userService.getFollowing('bramdb').subscribe(users => {
      this.users = users;
    });
  }
}
