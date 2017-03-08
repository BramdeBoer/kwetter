package dao;

import model.Tweet;
import model.User;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by bramd on 6-3-2017.
 */
@Stateless
public class UserDaoImp implements UserDao {
    @PersistenceContext
    EntityManager em;

    public UserDaoImp() {

    }

    public User addUser(User user) {
        return null;
    }

    public User getUserByUsername(String username) {
        return null;
    }

    public List<Tweet> getRecentTweets(User user, int offset, int limit) {
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

    public String getBio(User u) {
        return null;
    }

    public String getLocation(User u) {
        return null;
    }

    public String getWebsiteURL(User u) {
        return null;
    }

    public String getAvatarURL(User u) {
        return null;
    }

    public String getUsername(User u) {
        return null;
    }
}
