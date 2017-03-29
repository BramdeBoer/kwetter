package bean;

import interceptor.VolgTrend;
import model.Tweet;
import model.User;
import service.TweetService;
import service.UserService;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

/**
 * Created by bramd on 29-3-2017.
 */
@Named(value = "TweetBean")
@RequestScoped
public class TweetBean implements Serializable {

    @Inject
    private TweetService tweetService;

    private User user;
    private String content;

    public Tweet getTweet(int id){
        return tweetService.getTweet(id);
    }

    public List<Tweet> findByContent(String query) {
        return tweetService.findByContent(query);
    }

    public Tweet create(String content, User user) {
        return tweetService.create(content, user);
    }

    public boolean remove(Tweet tweet) {
        return tweetService.remove(tweet);
    }
}
