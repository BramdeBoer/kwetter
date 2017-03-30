package bean;

import model.Tweet;
import model.User;
import service.UserService;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

/**
 * Created by bramd on 6-3-2017.
 */
@Named(value = "UserBean")
@RequestScoped
public class UserBean implements Serializable {

    @Inject
    private UserService userService;
    private User user;
    private String username = FacesContext.getCurrentInstance().getExternalContext().getRemoteUser();

    public User getUser() {
        return user;
    }

    public void logout(){
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        FacesContext.getCurrentInstance().getApplication().getNavigationHandler().handleNavigation(FacesContext.getCurrentInstance(), null, "login.xhtml");
    }

    public User getUserByUsername(String username) {
        return userService.getUserByUsername(username);
    }

    public List<Tweet> getRecentTweets(User user, int offset, int limit) {
        return userService.getRecentTweets(user, offset, limit);
    }

    public List<User> getFollowers(User user) {
        return userService.getFollowers(user);
    }

    public List<User> getFollowing(User user) {
        return userService.getFollowing(user);
    }

    public List<Tweet> getTimelineTweets(User user, int offset, int limit) {
        return userService.getTimelineTweets(user, offset, limit);
    }

    public String getUsername() {
        return username;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void loadUser() {
        User user = userService.getUserByUsername(username);
        this.setUser(user);
    }

    public void setUsername(String username) {
        this.username = username;
    }
}