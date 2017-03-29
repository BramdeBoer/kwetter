package service;

import junit.framework.TestCase;
import model.Tweet;
import model.User;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bramd on 9-3-2017.
 */
public class UserServiceTest extends TestCase {

    UserService userService = Mockito.mock(UserService.class);


    User user1, user2, user3, user4, user5, user6, user7, user8, user9, user10;

    Tweet tweet1, tweet2, tweet3, tweet4, tweet5, tweet6, tweet7, tweet8, tweet9, tweet10;

    public void setUp() throws Exception {
        super.setUp();

        Mockito.when(userService.addUser(new User())).thenReturn(new User());
        Mockito.when(userService.getUserByUsername("Peter Monroe")).thenReturn(user1);
        Mockito.when(userService.getUserByUsername("Theo Hubers")).thenReturn(user2);
        Mockito.when(userService.getUserByUsername("Theo Hubers")).thenReturn(user8);

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
}