package dao;

import event.AddTweetEvent;
import model.Tweet;
import model.User;

import javax.enterprise.event.Observes;
import java.util.List;

public interface TweetDao {

    Tweet getTweet(int id);

    List<Tweet> findByContent(String query);

    Tweet create(String content, User user);

    boolean remove(Tweet tweet);

    void addKweet(@Observes AddTweetEvent addTweetEvent);

}
