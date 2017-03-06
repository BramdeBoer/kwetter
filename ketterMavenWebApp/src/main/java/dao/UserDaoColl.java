package dao;

import model.Tweet;
import model.User;

import java.util.List;

/**
 * Created by bramd on 6-3-2017.
 */
public class UserDaoColl implements UserDao {
    public User getUserByUsername(String username) {
        return null;
    }

    public List<Tweet> getRecentTweets(User user) {
        return null;
    }

    public List<User> getFollowers(User user) {
        return null;
    }

    public List<User> getFollowing(User user) {
        return null;
    }

    public List<Tweet> getTimelineTweets(User user, int offset, int limit) {
        return null;
    }

    public boolean setAvatar(User user, String url) {
        return false;
    }

    public boolean setWebsite(User user, String url) {
        return false;
    }

    public boolean setLocation(User user, String location) {
        return false;
    }

    public boolean setBio(User user, String bio) {
        return false;
    }

    public boolean setUsername(User user, String username) {
        return false;
    }
}
