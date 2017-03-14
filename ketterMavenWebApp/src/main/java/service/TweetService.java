package service;

import dao.JPA;
import dao.TweetDao;
import dao.TweetDaoColl;
import model.Tweet;
import model.User;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by bramd on 9-3-2017.
 */
@Stateless
public class TweetService {
    @Inject @JPA
    private TweetDao tweetDao;

    public Tweet getTweet(int id){
        return tweetDao.getTweet(id);
    }

    public TweetService(){
        //tweetDao = new TweetDao();
    }

    public List<Tweet> findByContent(String query) {
        return tweetDao.findByContent(query);
    }

    public Tweet create(String content, User user) {
        return tweetDao.create(content, user);
    }

    public boolean remove(Tweet tweet) {
        return tweetDao.remove(tweet);
    }
}
