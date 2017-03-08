package dao;

import model.Tweet;
import model.User;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by bramd on 6-3-2017.
 */
public class UserDaoColl implements UserDao {
    private List<User> users;

    public UserDaoColl() {
        users = new ArrayList<User>();
    }

    public User getUserByUsername(String username) {
        User foundUser = null;
        for (User user : this.users) {
            if (user.getUsername().equals(username)) {
                foundUser = user;
            }
        }
        return foundUser;
    }

    public List<Tweet> getRecentTweets(User user, int offset, int limit) {
        return user.getRecentTweets(offset, limit);
    }

    public List<User> getFollowers(User user) {
        return user.getFollowers();
    }

    public List<User> getFollowing(User user) {
        return user.getFollowing();
    }

    public List<Tweet> getTimelineTweets(User user, int offset, int limit) {
        return user.getTimelineTweets(offset, limit);
    }

    public boolean setAvatar(User user, String url) {
        return user.setAvatarURL(url);
    }

    public boolean setWebsite(User user, String url) {
        return user.setWebsiteURL(url);
    }

    public boolean setLocation(User user, String location) {
        return user.setLocation(location);
    }

    public boolean setBio(User user, String bio) {
        return user.setBio(bio);
    }

    public boolean setUsername(User user, String username) {
        return user.setUsername(username);
    }
}
