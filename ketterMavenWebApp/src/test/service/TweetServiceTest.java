package service;

import dao.TweetDao;
import dao.TweetDaoColl;
import junit.framework.TestCase;
import model.Tweet;
import model.User;
import org.junit.runner.RunWith;

/**
 * Created by bramd on 9-3-2017.
 */
public class TweetServiceTest extends TestCase {
    TweetService tweetService;

    User user1;
    User user2;
    User user3;
    User user4;
    User user5;

    Tweet tweet1;
    Tweet tweet2;
    Tweet tweet3;
    Tweet tweet4;
    Tweet tweet5;

    public void setUp() throws Exception {
        super.setUp();

        tweetService = new TweetService();

        user1 = new User();
        tweet1 = tweetService.create("1 #TEST", user1);


        user2 = new User();
        tweet2 = tweetService.create("2 #TEST", user2);

        user3 = new User();
        tweet3 = tweetService.create("3 #TEST", user3);

        user4 = new User();
        tweet4 = tweetService.create("4 #TEST", user4);

        user5 = new User();
        tweet5 = tweetService.create("5 #TEST", user5);

        user1.follow(user2);
        user1.follow(user3);
        user1.follow(user4);

        user2.likeTweet(tweet3);

        user2.follow(user3);
        user3.follow(user4);
    }

    public void tearDown() throws Exception {

    }

    public void testFindByContent() throws Exception {
        assertEquals(1, tweetService.findByContent("1 #").size());
        assertEquals(5, tweetService.findByContent("#TEST").size());
        assertEquals(tweet1, tweetService.findByContent("1 #").get(0));
        assertEquals(tweet1, tweetService.findByContent("#test").get(0));
        assertEquals(tweet1, tweetService.findByContent("#TEST").get(0));
    }

    public void testRemove() throws Exception {
        assertTrue(tweetService.remove(tweet5));
        assertEquals(0, user5.getTweets().size());
        assertFalse(tweetService.remove(tweet5));
    }
}