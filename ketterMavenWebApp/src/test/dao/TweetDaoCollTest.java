package dao;

import junit.framework.TestCase;
import model.Tweet;
import model.User;

/**
 * Created by bramd on 8-3-2017.
 */
public class TweetDaoCollTest extends TestCase {

    TweetDao tweetdao;


    User user1, user2, user3, user4, user5;

    Tweet tweet1, tweet2, tweet3, tweet4, tweet5;

    public void setUp() throws Exception {
        super.setUp();

        tweetdao = new TweetDaoColl();

        user1 = new User();
        tweet1 = tweetdao.create("1 #TEST", user1);


        user2 = new User();
        tweet2 = tweetdao.create("2 #TEST", user2);

        user3 = new User();
        tweet3 = tweetdao.create("3 #TEST", user3);

        user4 = new User();
        tweet4 = tweetdao.create("4 #TEST", user4);

        user5 = new User();
        tweet5 = tweetdao.create("5 #TEST", user5);

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
        assertEquals(1, tweetdao.findByContent("1 #").size());
        assertEquals(5, tweetdao.findByContent("#TEST").size());
        assertEquals(tweet1, tweetdao.findByContent("1 #").get(0));
        assertEquals(tweet1, tweetdao.findByContent("#test").get(0));
        assertEquals(tweet1, tweetdao.findByContent("#TEST").get(0));
    }

    public void testRemove() throws Exception {
        assertTrue(tweetdao.remove(tweet5));
        assertEquals(0, user5.getTweets().size());
        assertFalse(tweetdao.remove(tweet5));
    }

}