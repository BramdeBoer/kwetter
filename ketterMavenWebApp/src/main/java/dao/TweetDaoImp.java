package dao;

import model.Tweet;
import model.User;

import java.util.List;

/**
 * Created by bramd on 6-3-2017.
 */
public class TweetDaoImp implements TweetDao{
    public List<Tweet> findByContent(String query) {
        return null;
    }

    public boolean create(String content, User user) {
        return false;
    }

    public boolean remove(Tweet tweet) {
        return false;
    }
}
