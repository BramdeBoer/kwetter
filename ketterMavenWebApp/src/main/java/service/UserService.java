package service;

import dao.UserDao;
import model.Tweet;
import model.User;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

/**
 * Created by bramd on 6-3-2017.
 */
@Stateless
public class UserService {
    @Inject
    private UserDao userDao;

    public UserService() {
    }

    public User addUser(User user) {
        return userDao.addUser(user);
    }

    public User getUserByUsername(String username) {
        return userDao.getUserByUsername(username);
    }

    public List<Tweet> getRecentTweets(User user, int offset, int limit) {
        return userDao.getRecentTweets(user, offset, limit);
    }

    public List<User> getFollowers(User user) {
        return userDao.getFollowers(user);
    }

    public List<User> getFollowing(User user) {
        return userDao.getFollowing(user);
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

    public String getBio(User u) {
        return u.getBio();
    }

    public String getLocation(User u) {
        return u.getLocation();
    }

    public String getWebsiteURL(User u) {
        return u.getWebsiteURL();
    }

    public String getAvatarURL(User u) {
        return u.getAvatarURL();
    }

    public String getUsername(User u) {
        return u.getUsername();
    }
}
