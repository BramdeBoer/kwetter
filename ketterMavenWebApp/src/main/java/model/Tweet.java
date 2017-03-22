package model;

import interceptor.VolgTrend;

import javax.enterprise.inject.Model;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by bramd on 6-3-2017.
 */
@Entity @Model
public class Tweet implements Comparable<Tweet> {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String content;
    private Date date;

    @OneToOne
    private User createdBy;
    @OneToMany
    private List<User> likedBy;

    public Tweet() {
    }

    public Tweet(String content, User createdBy) {
        this.content = content;
        this.createdBy = createdBy;
        this.date = new Date(System.currentTimeMillis());
        this.likedBy = new ArrayList();

        createdBy.addTweet(this);
    }

    public boolean addLike(User user){
        if(!likedBy.contains(user)){
            likedBy.add(user);
            return true;
        }
        return false;
    }

    public int compareTo(Tweet o) {
        return getDate().compareTo(o.getDate());
    }

    public Date getDate() {
        return date;
    }

    public String getContent() {
        return content;
    }

    public List<User> getLikedBy() {
        return likedBy;
    }

    public User getCreatedBy() {
        return createdBy;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }

    public void setLikedBy(List<User> likedBy) {
        this.likedBy = likedBy;
    }

    @Override
    public String toString() {
        return "Tweet{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", date=" + date +
                ", createdBy=" + createdBy +
                ", likedBy=" + likedBy +
                '}';
    }
}
