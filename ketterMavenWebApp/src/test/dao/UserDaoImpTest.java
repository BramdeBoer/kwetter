package dao;

import junit.framework.TestCase;
import model.Tweet;
import model.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import util.DatabaseCleaner;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by bramd on 9-3-2017.
 */
//@RunWith(CdiRunner.class)
public class UserDaoImpTest extends TestCase {

    UserDao userdao;

    DatabaseCleaner databaseCleaner;

    User user1, user2, user3, user4, user5, user6, user7, user8, user9, user10;

    Tweet tweet1, tweet2, tweet3, tweet4, tweet5, tweet6, tweet7, tweet8, tweet9, tweet10;

    @Before
    public void setUp() throws Exception {
        super.setUp();


        databaseCleaner = new DatabaseCleaner(Persistence.createEntityManagerFactory("KwetterPU").createEntityManager());
        databaseCleaner.clean();

        userdao = new UserDaoImp();
        ((UserDaoImp)userdao).em = Persistence.createEntityManagerFactory("KwetterPU").createEntityManager();

        user1 = userdao.addUser(new User());
        tweet1 = new Tweet("1 #TEST", user1);

        user2 = userdao.addUser(new User());
        tweet2 = new Tweet("2 #TEST", user2);

        user3 = userdao.addUser(new User());
        tweet3 = new Tweet("3 #TEST", user3);

        user4 = userdao.addUser(new User());
        tweet4 = new Tweet("4 #TEST", user4);

        user5 = userdao.addUser(new User());
        tweet5 = new Tweet("5 #TEST", user5);

        user6 = userdao.addUser(new User());
        tweet6 = new Tweet("6 #TEST", user6);

        user7 = userdao.addUser(new User());
        tweet7 = new Tweet("7 #TEST", user7);

        user8 = userdao.addUser(new User());
        tweet8 = new Tweet("8 #TEST", user8);

        user9 = userdao.addUser(new User());
        tweet9 = new Tweet("9 #TEST", user9);

        user10 = userdao.addUser(new User());
        tweet10 = new Tweet("10 #TEST", user10);

        user1.follow(user2);
        user1.follow(user3);
        user1.follow(user4);

        user2.likeTweet(tweet3);

        user2.follow(user3);
        user3.follow(user4);
    }

    @After
    public void tearDown() throws Exception {

        databaseCleaner = new DatabaseCleaner(Persistence.createEntityManagerFactory("KwetterPU").createEntityManager());
        databaseCleaner.clean();
    }

    @Test
    public void testAddUser() throws Exception{
        assertEquals(null, userdao.addUser(user1));
    }

    @Test
    public void testGetUserByUsername() throws Exception {
        user1.setUsername("Peter Monroe");
        user2.setUsername("Theo Hubers");
        user8.setUsername("Hackerman");

        assertEquals(user1, userdao.getUserByUsername("Peter Monroe"));
        assertEquals(user2, userdao.getUserByUsername("Theo Hubers"));
        assertEquals(user8, userdao.getUserByUsername("Hackerman"));
        assertEquals(null, userdao.getUserByUsername("Herman"));
    }

    @Test
    public void testGetRecentTweets() throws Exception {
        List<Tweet> user1Tweets = new ArrayList<Tweet>();
        user1Tweets.add(tweet1);
        assertEquals(user1Tweets, userdao.getRecentTweets(user1, 0, 2));
        user1Tweets.add(new Tweet("#11 Test", user1));
        assertEquals(user1Tweets, userdao.getRecentTweets(user1, 0, 2));
    }

    @Test
    public void testGetFollowers() throws Exception {
        List<User> userList = new ArrayList<User>();
        userList.add(user1);
        assertEquals(userList, userdao.getFollowers(user2));
        user2.follow(user3);
        userList.add(user2);
        assertEquals(userList, userdao.getFollowers(user3));
    }

    @Test
    public void testGetFollowing() throws Exception {
        List<User> userList = new ArrayList<User>();
        userList.add(user2);
        userList.add(user3);
        userList.add(user4);
        assertEquals(userList, userdao.getFollowing(user1));
    }

    @Test
    public void testGetTimelineTweets() throws Exception {
        assertEquals(4, userdao.getTimelineTweets(user1, 0, 8).size());
        assertEquals(tweet3, userdao.getTimelineTweets(user1, 2, 1).get(0));
    }
}