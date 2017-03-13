package dao;

import model.Tweet;
import model.User;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import java.util.List;

/**
 * Created by bramd on 6-3-2017.
 */
@Stateless @JPA
public class TweetDaoImp implements TweetDao{
    @PersistenceContext(unitName = "KwetterPU")
    EntityManager em;

    public Tweet getTweet(int id) {
        Tweet tweet;
        try{
            tweet = em.find(Tweet.class, id);
        }catch (Exception ex){
            tweet = null;
        }
        return tweet;
    }

    public List<Tweet> findByContent(String query) {
        return null;
    }

    public Tweet create(String content, User user) {
        Tweet tweet = null;
        try{
            tweet = new Tweet(content, user);
            em.persist(tweet);
        }catch (Exception ex){
            System.out.println(ex.getMessage());
            tweet = null;
        }
        return tweet;
    }

    public boolean remove(Tweet tweet) {
        try{
            em.remove(tweet);
        }catch (Exception ex){
            System.out.println(ex.getMessage());
            return false;
        }
        return true;
    }
}
