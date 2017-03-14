package model;

import junit.framework.TestCase;

/**
 * Created by bramd on 8-3-2017.
 */
public class ModelTest extends TestCase {


    User user1, user2, user3, user4, user5, user6, user7, user8, user9, user10;

    Tweet tweet1, tweet2, tweet3, tweet4, tweet5, tweet6, tweet7, tweet8, tweet9, tweet10;

    public void setUp() throws Exception {
        super.setUp();

        user1 = new User();
        tweet1 = new Tweet("1 #TEST", user1);

        user2 = new User();
        tweet2 = new Tweet("2 #TEST", user2);

        user3 = new User();
        tweet3 = new Tweet("3 #TEST", user3);

        user4 = new User();
        tweet4 = new Tweet("4 #TEST", user4);

        user5 = new User();
        tweet5 = new Tweet("5 #TEST", user5);

        user6 = new User();
        tweet6 = new Tweet("6 #TEST", user6);

        user7 = new User();
        tweet7 = new Tweet("7 #TEST", user7);

        user8 = new User();
        tweet8 = new Tweet("8 #TEST", user8);

        user9 = new User();
        tweet9 = new Tweet("9 #TEST", user9);

        user10 = new User();
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

    public void testAddTweet() throws Exception {
        assertEquals(tweet1, user1.getTweets().get(0));
    }

    public void testGetRecentTweets() throws Exception {
        User user = new User();
        Tweet tweet1 = new Tweet("1 #TEST", user);
        Tweet tweet2 = new Tweet("2 #TEST", user);
        Tweet tweet3 = new Tweet("3 #TEST", user);
        Tweet tweet4 = new Tweet("4 #TEST", user);
        Tweet tweet5 = new Tweet("5 #TEST", user);
        Tweet tweet6 = new Tweet("6 #TEST", user);
        Tweet tweet7 = new Tweet("7 #TEST", user);
        Tweet tweet8 = new Tweet("8 #TEST", user);
        Tweet tweet9 = new Tweet("9 #TEST", user);
        Tweet tweet10 = new Tweet("10 #TEST", user);

        assertEquals(user.getTweets(), user.getRecentTweets(0,10));
        assertEquals(user.getTweets().subList(0,5), user.getRecentTweets(0,5));
    }

    public void testLikeTweet() throws Exception {
        assertEquals(user2, tweet3.getLikedBy().get(0));

        user2.likeTweet(tweet3);//Test dubbele like
        assertEquals(1, tweet3.getLikedBy().size());
    }

    public void testGetTimelineTweets() throws Exception {
        assertEquals(4, user1.getTimelineTweets(0,8).size());
        assertEquals(tweet3, user1.getTimelineTweets(2,1).get(0));
    }

    public void testSetName() throws Exception {
        String testString =  "test";
        User u = new User();
        u.setName(testString);
        assertEquals(testString, u.getName());
    }

    public void testSetBio() throws Exception {
        String testString =  "test";
        User u = new User();
        u.setBio(testString);
        assertEquals(testString, u.getBio());
    }

    public void testSetAvatarURL() throws Exception {
        String testString =  "test";
        User u = new User();
        u.setAvatarURL(testString);
        assertEquals(testString, u.getAvatarURL());
    }

    public void testSetWebsiteURL() throws Exception {
        String testString =  "test";
        User u = new User();
        u.setWebsiteURL(testString);
        assertEquals(testString, u.getWebsiteURL());
    }

    public void testSetUsername() throws Exception {
        String testString =  "test";
        User u = new User();
        u.setUsername(testString);
        assertEquals(testString, u.getUsername());
    }

    public void testSetLocation() throws Exception {
        String testString = "Woensel";
        User u = new User();
        u.setLocation(testString);
        assertEquals(testString, u.getLocation());
    }

    public void testGetFollowing() throws Exception {
        assertEquals(3, user1.getFollowing().size());
    }

    public void testGetFollowers() throws Exception {
        assertEquals(2, user3.getFollowers().size());
        assertEquals(0, user1.getFollowers().size());
    }

    public void testRemoveTweet() throws Exception{
        user1.removeTweet(tweet1);
        assertEquals(0, user1.getTweets().size());
    }
}