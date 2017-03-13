package rest;

import model.Tweet;
import model.User;
import service.TweetService;
import service.UserService;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by bramd on 13-3-2017.
 */
@Stateless
@Path("tweets")
@Produces(MediaType.APPLICATION_JSON)
public class TweetRest {

    @Inject
    TweetService tweetService;

    @Inject
    UserService userService;

    @GET
    @Path("{content}")
    public List<Tweet> findTweetByContent(@PathParam("content") String query) {
        return tweetService.findByContent(query);
    }

    @POST
    @Path("{content}/{username}")
    public Tweet create(@PathParam("content") String content, @PathParam("username") String username) {
        return tweetService.create(content, userService.getUserByUsername(username));
    }

    @DELETE
    @Path("{id}")
    public boolean remove(@PathParam("id") int id){
        return tweetService.remove(tweetService.getTweet(id));
    }

}
