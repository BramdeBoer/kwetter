package bean;

import interceptor.VolgTrend;
import model.Tweet;
import model.User;
import service.TweetService;
import service.UserService;

import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
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

    @Inject
    private UserService userService;
    private String username = FacesContext.getCurrentInstance().getExternalContext().getRemoteUser();

    private User user;

    private String content;

    public Tweet getTweet(int id){
        return tweetService.getTweet(id);
    }

    public List<Tweet> findByContent(String query) {
        return tweetService.findByContent(query);
    }

    public Tweet create() {
        return tweetService.create(this.content, userService.getUserByUsername(username));
    }

    public boolean remove(Tweet tweet) {
        return tweetService.remove(tweet);
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUsername() {
        return username;
    }

    public void loadUser() {
        User user = userService.getUserByUsername(username);
        this.setUser(user);
    }

    public void setUsername(String username) {
        this.username = username;
    }


}
