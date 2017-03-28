package batch;

import model.Tweet;
import service.UserService;

import javax.batch.api.chunk.ItemProcessor;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;

@Dependent
@Named("TweetProcessor")
public class TweetProcessor implements ItemProcessor {

    @Inject
    UserService userService;

    @Override
    public Object processItem(Object item) throws Exception {
        InputTweet inputTweet = (InputTweet) item;
        // some processing

        System.out.println("TweetProcessor");

        Tweet tweet = new Tweet();
        tweet.setCreatedBy(userService.getUserByUsername(inputTweet.username));
        tweet.setContent(inputTweet.content);
        System.out.println(tweet.toString());
      
        return tweet;
    }
  
}
