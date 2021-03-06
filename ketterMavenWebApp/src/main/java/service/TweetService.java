package service;

import dao.JPA;
import dao.TweetDao;
import dao.TweetDaoColl;
import event.AddTweetEvent;
import interceptor.VolgTrend;
import interceptor.VolgTrendInterceptor;
import model.Tweet;
import model.User;

import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.interceptor.Interceptors;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by bramd on 9-3-2017.
 */
@Interceptors(VolgTrendInterceptor.class)
@Stateless
public class TweetService {
    @Inject @JPA
    private TweetDao tweetDao;

    @Inject
    private Event<AddTweetEvent> addTweetEventEvent;

    public Tweet getTweet(int id){
        return tweetDao.getTweet(id);
    }

    public TweetService(){
        //tweetDao = new TweetDao();
    }

    /**
     * Search tweets with content contain query
     * @param query
     * @return List of tweets
     */
    public List<Tweet> findByContent(String query) {
        return tweetDao.findByContent(query);
    }

    /**
     * Create a tweet
     * @param content
     * @param user
     * @return Tweet thats created if succesfull
     */
    @VolgTrend
    public Tweet create(String content, User user) {
        Tweet tweet = new Tweet(content, user);
        AddTweetEvent event = new AddTweetEvent(tweet);
        addTweetEventEvent.fire(event);
        return tweet;
    }

    /**
     * Remove tweet
     * @param tweet
     * @return return true if success, false if not
     */
    public boolean remove(Tweet tweet) {
        return tweetDao.remove(tweet);
    }
}
