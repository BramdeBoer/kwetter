package batch;

import model.Tweet;
import service.TweetService;

import javax.batch.api.chunk.ItemWriter;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Dependent
@Named("TweetWriter")
public class TweetWriter implements ItemWriter {
    
    @Inject
    private TweetService service;

   
    @Override
    public void close() throws Exception {
    }

    @Override
    public void writeItems(List<Object> items) throws Exception {

        for (Object item : items) {
            Tweet tweet = (Tweet) item;

            System.out.println("CREATING TWEET" + tweet.toString());
            service.create(tweet.getContent(), tweet.getCreatedBy());
        }
    }

    @Override
    public Serializable checkpointInfo() throws Exception {
       return null;
    }

    @Override
    public void open(Serializable checkpoint) throws Exception {
    }
   
}
