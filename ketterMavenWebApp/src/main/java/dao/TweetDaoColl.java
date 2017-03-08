package dao;

import model.Tweet;
import model.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bramd on 6-3-2017.
 */
public class TweetDaoColl implements TweetDao {
    private List<Tweet> tweets;

    public TweetDaoColl() {
        this.tweets = new ArrayList<Tweet>();
    }

    public List<Tweet> findByContent(String query) {
        List<Tweet> foundTweets = new ArrayList<Tweet>();
        for (Tweet tweet : this.tweets) {
            if (tweet.getContent().toLowerCase().contains(query.toLowerCase())) {
                foundTweets.add(tweet);
            }
        }
        return foundTweets;
    }

    public boolean create(String content, User user) {
        Tweet newTweet = new Tweet(content, user);
        if (!this.tweets.contains(newTweet)) {
            this.tweets.add(newTweet);
            return true;
        }
        return false;
    }

    public boolean remove(Tweet tweet) {
        if (this.tweets.contains(tweet)) {
            this.tweets.remove(tweet);
            return true;
        }
        return false;
    }
}
