package dao;

import model.Tweet;
import model.User;

import java.util.List;

/**
 * Created by bramd on 6-3-2017.
 */
public interface UserDao {

    User addUser(User user);

    List<User> getUsers();

    User getUserByUsername(String username);

    List<Tweet> getRecentTweets(User user, int offset, int limit);

    List<User> getFollowers(User user);

    List<User> getFollowing(User user);

    List<Tweet> getTimelineTweets(User user, int offset, int limit);

    void follow(User user, User followUser);

    List<User> searchByUsername(String username);
}
