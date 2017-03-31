package dao;

import model.Tweet;
import model.User;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by bramd on 6-3-2017.
 */
@Stateless @JPA
public class UserDaoImp implements UserDao {
    @PersistenceContext(unitName = "KwetterPU")
    EntityManager em;

    public UserDaoImp() {

    }

    public User addUser(User user) {
        try{
            em.persist(user);
        }catch (Exception ex){
            System.out.println(ex.getMessage());
            user = null;
        }
        return user;
    }

    public List<User> getUsers() {
        List<User> results = em
                .createQuery("Select u from User u", User.class)
                .getResultList();
        return results;
    }

    public User getUserByUsername(String username) {
        User user;
        try{
            TypedQuery<User> query = em.createNamedQuery("user.findByName", User.class);
            query.setParameter("username", username);
            user = query.getSingleResult();
        }catch (Exception ex){
            System.out.println("AAAAAAAAAAAAAAAAAAAA" +  ex);
            user = null;
        }
        return user;
    }

    public List<Tweet> getRecentTweets(User user, int offset, int limit) {
        List<Tweet> tweets;
        try{
            tweets = em.find(User.class, user.getId()).getRecentTweets(offset, limit);
        }catch (Exception ex){
            System.out.println("AAAAAAAAAAAAAAAAAAAA" +  ex);
            ex.printStackTrace(System.out);
            tweets = null;
        }
        return tweets;
    }

    public List<User> getFollowers(User user) {
        List<User> users;
        try{
            users = em.find(User.class, user.getId()).getFollowers();
        }catch (Exception ex){
            users = null;
        }
        return users;
    }

    public List<User> getFollowing(User user) {
        List<User> users;
        try{
            users = em.find(User.class, user.getId()).getFollowing();
        }catch (Exception ex){
            users = null;
        }
        return users;
    }

    public List<Tweet> getTimelineTweets(User user, int offset, int limit) {
        List<Tweet> tweets;
        try{
            System.out.println( em.find(User.class, user.getId()).getUsername());
            tweets = em.find(User.class, user.getId()).getTimelineTweets(offset, limit);
        }catch (Exception ex){
            tweets = null;
        }
        return tweets;
    }

    public void follow(User user, User followUser) {
        try{
            em.find(User.class, user.getId()).follow(followUser);
        }catch (Exception ex){
            System.out.println("AAAAAAAAAAAAAAAAAAAA" +  ex);
        }
    }

    @Override
    public List<User> searchByUsername(String username) {
        List<User> users;
        try{
            TypedQuery<User> query = em.createNamedQuery("user.searchByUsername", User.class);
            query.setParameter("username", username);
            users = query.getResultList();
        }catch (Exception ex){
            System.out.println("AAAAAAAAAAAAAAAAAAAA" +  ex);
            users = null;
        }
        return users;
    }
}
