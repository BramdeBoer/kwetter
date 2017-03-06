package dao;

import model.Tweet;
import model.User;

import java.util.List;

/**
 * Created by bramd on 6-3-2017.
 */
public interface UserDao {

    User getUserByUsername(String username);

    List<Tweet> getRecentTweets(User user);

    List<User> getFollowers(User user);

    List<User> getFollowing(User user);

    List<Tweet> getTimelineTweets(User user, int offset, int limit);

    boolean setAvatar(User user, String url);

    boolean setWebsite(User user, String url);

    boolean setLocation(User user, String location);

    boolean setBio(User user, String bio);

    boolean setUsername(User user, String username);




}
