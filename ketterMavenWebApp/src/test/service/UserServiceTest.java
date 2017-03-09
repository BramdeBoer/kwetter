package service;

import junit.framework.TestCase;
import model.Tweet;
import model.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bramd on 9-3-2017.
 */
public class UserServiceTest extends TestCase {

    UserService userService;

    User user1;
    User user2;
    User user3;
    User user4;
    User user5;
    User user6;
    User user7;
    User user8;
    User user9;
    User user10;

    Tweet tweet1;
    Tweet tweet2;
    Tweet tweet3;
    Tweet tweet4;
    Tweet tweet5;
    Tweet tweet6;
    Tweet tweet7;
    Tweet tweet8;
    Tweet tweet9;
    Tweet tweet10;

    public void setUp() throws Exception {
        super.setUp();
        userService = new UserService();

        user1 = userService.addUser(new User());
        tweet1 = new Tweet("1 #TEST", user1);

        user2 = userService.addUser(new User());
        tweet2 = new Tweet("2 #TEST", user2);

        user3 = userService.addUser(new User());
        tweet3 = new Tweet("3 #TEST", user3);

        user4 = userService.addUser(new User());
        tweet4 = new Tweet("4 #TEST", user4);

        user5 = userService.addUser(new User());
        tweet5 = new Tweet("5 #TEST", user5);

        user6 = userService.addUser(new User());
        tweet6 = new Tweet("6 #TEST", user6);

        user7 = userService.addUser(new User());
        tweet7 = new Tweet("7 #TEST", user7);

        user8 = userService.addUser(new User());
        tweet8 = new Tweet("8 #TEST", user8);

        user9 = userService.addUser(new User());
        tweet9 = new Tweet("9 #TEST", user9);

        user10 = userService.addUser(new User());
        tweet10 = new Tweet("10 #TEST", user10);

        user1.follow(user2);
        user1.follow(user3);
        user1.follow(user4);

        user2.likeTweet(tweet3);

        user2.follow(user3);
        user3.follow(user4);
    }

    public void tearDown() throws Exception {

    }

    public void testAddUser() throws Exception{
        assertEquals(null, userService.addUser(user1));
    }

    public void testGetUserByUsername() throws Exception {
        user1.setUsername("Peter Monroe");
        user2.setUsername("Theo Hubers");
        user8.setUsername("Hackerman");

        assertEquals(user1, userService.getUserByUsername("Peter Monroe"));
        assertEquals(user2, userService.getUserByUsername("Theo Hubers"));
        assertEquals(user8, userService.getUserByUsername("Hackerman"));
        assertEquals(null, userService.getUserByUsername("Herman"));
    }

    public void testGetRecentTweets() throws Exception {
        List<Tweet> user1Tweets = new ArrayList<Tweet>();
        user1Tweets.add(tweet1);
        assertEquals(user1Tweets, userService.getRecentTweets(user1, 0, 2));
        user1Tweets.add(new Tweet("#11 Test", user1));
        assertEquals(user1Tweets, userService.getRecentTweets(user1, 0, 2));
    }

    public void testGetFollowers() throws Exception {
        List<User> userList = new ArrayList<User>();
        userList.add(user1);
        assertEquals(userList, userService.getFollowers(user2));
        user2.follow(user3);
        userList.add(user2);
        assertEquals(userList, userService.getFollowers(user3));
    }

    public void testGetFollowing() throws Exception {
        List<User> userList = new ArrayList<User>();
        userList.add(user2);
        userList.add(user3);
        userList.add(user4);
        assertEquals(userList, userService.getFollowing(user1));
    }

    public void testGetTimelineTweets() throws Exception {
        assertEquals(4, userService.getTimelineTweets(user1, 0, 8).size());
        assertEquals(tweet3, userService.getTimelineTweets(user1, 2, 1).get(0));
    }

}