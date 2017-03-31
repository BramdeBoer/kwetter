package service;

import dao.JPA;
import dao.UserDao;
import dao.UserDaoColl;
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
    @Inject @JPA
    private UserDao userDao;

    public UserService() {
        //userDao = new UserDaoColl();
    }

    /**
     * Get all users
     * @return all users
     */
    public List<User> getUsers() {
        return userDao.getUsers();
    }

    /**
     * adds user
     * @param user
     * @return returns added user
     */
    public User addUser(User user) {
        return userDao.addUser(user);
    }

    /**
     * gets user object by its username
     * @param username
     * @return user corresponding with username
     */
    public User getUserByUsername(String username) {
        return userDao.getUserByUsername(username);
    }

    /**
     * Get recent tweets of a specific user
     * @param user
     * @param offset where to start
     * @param limit
     * @return list of tweets
     */
    public List<Tweet> getRecentTweets(User user, int offset, int limit) {
        return userDao.getRecentTweets(user, offset, limit);
    }

    /**
     * Get followers of a user
     * @param user
     * @return followers
     */
    public List<User> getFollowers(User user) {
        return userDao.getFollowers(user);
    }

    /**
     * Get users the specific user follows
     * @param user
     * @return Following
     */
    public List<User> getFollowing(User user) {
        return userDao.getFollowing(user);
    }

    /**
     * Get the tweets of the user and its followings users.
     * @param user
     * @param offset
     * @param limit
     * @return Timeline tweets
     */
    public List<Tweet> getTimelineTweets(User user, int offset, int limit) {
        return userDao.getTimelineTweets(user, offset, limit);
    }

    public void follow(User user, User followUser){
        userDao.follow(user, followUser);
    }


    /**
     * search user object by its username
     * @param username
     * @return user corresponding with username
     */
    public List<User> searchByUsername(String username) {
        if(username.length() > 2){
            return userDao.searchByUsername(username);
        }
        return null;
    }

}
