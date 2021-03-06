import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';

import { routing } from './app.routing';
import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { TimelineComponent } from './timeline/timeline.component';
import { HomeComponent } from './home/home.component';
import { ProfileComponent } from './profile/profile.component';
import { LoginComponent } from './login/login.component';
import { HttpService } from "app/http.service";
import { TweetService } from "app/tweet.service";
import { UserService } from "app/user.service";
import { TweetComponent } from './tweet/tweet.component';
import { UsertweetsComponent } from './usertweets/usertweets.component';
import { FollowingComponent } from './following/following.component';
import { FollowersComponent } from './followers/followers.component';
import { UserComponent } from './user/user.component';
import { TranslateModule } from 'ng2-translate';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    TimelineComponent,
    HomeComponent,
    ProfileComponent,
    LoginComponent,
    TweetComponent,
    UsertweetsComponent,
    FollowingComponent,
    FollowersComponent,
    UserComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    routing,
    TranslateModule.forRoot()
  ],
  providers: [
    HttpService,
    HttpModule,
    TweetService,
    UserService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
