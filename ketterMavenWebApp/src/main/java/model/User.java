package model;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Entity @Model
public class User {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String type;
    private String bio;
    private String location;
    private String avatarURL;
    private String websiteURL;
    private String username;
    private String password;



    @ManyToMany
    private List<User> following;
    @ManyToMany
    private List<User> followers;
    @ManyToMany
    private List<Tweet> tweets;

    @PostConstruct
    private void initUser() {
        this.avatarURL = "/default/placeholder.png";
        this.tweets = new ArrayList<Tweet>();
        this.following = new ArrayList<User>();
        this.followers = new ArrayList<User>();
    }

    public User() {

    }

    public void addTweet(Tweet tweet){
        tweets.add(tweet);
    }

    public void addFollowing(User user){
        following.add(user);
    }

    public List<Tweet> getRecentTweets(int offset, int limit){
        return tweets.subList(offset, offset + limit);
    }

    public void likeTweet(Tweet tweet){
        tweet.addLike(this);
    }

    public List<Tweet> getTimelineTweets(int offset, int limit){
        ArrayList<Tweet> result = new ArrayList<Tweet>(getTweets());
        for (User user: following) {
            result.addAll(user.getTweets());
        }
        Collections.sort(result);
        return result.subList(offset, offset + limit);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getAvatarURL() {
        return avatarURL;
    }

    public void setAvatarURL(String avatarURL) {
        this.avatarURL = avatarURL;
    }

    public String getWebsiteURL() {
        return websiteURL;
    }

    public void setWebsiteURL(String websiteURL) {
        this.websiteURL = websiteURL;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<User> getFollowing() {
        return following;
    }

    public void setFollowing(List<User> following) {
        this.following = following;
    }

    public List<User> getFollowers() {
        return followers;
    }

    public void setFollowers(List<User> followers) {
        this.followers = followers;
    }

    public List<Tweet> getTweets() {
        return tweets;
    }

    public void setTweets(List<Tweet> tweets) {
        this.tweets = tweets;
    }
}
