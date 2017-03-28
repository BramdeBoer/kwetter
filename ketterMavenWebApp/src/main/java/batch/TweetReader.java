package batch;

import javax.batch.api.chunk.ItemReader;
import javax.batch.runtime.context.JobContext;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;
import javax.json.Json;
import javax.json.stream.JsonParser;
import java.io.InputStream;
import java.io.Serializable;

@Dependent
@Named("TweetReader")
public class TweetReader implements ItemReader {
    
    @Inject
    private JobContext jobContext;

    private String fileName;
    
    private JsonParser parser;

    private Checkpoint checkpoint;

    private boolean start;


    @Override
    public void open(Serializable srlzbl) throws Exception {
        if (checkpoint == null) {
            this.checkpoint = new Checkpoint();
        } else {
            this.checkpoint = (Checkpoint) checkpoint;
        }

        fileName = jobContext.getProperties().getProperty("input_file");
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream iStream = classLoader.getResourceAsStream(fileName);

        System.out.println("FILENAME " + fileName);
        
        parser = Json.createParser(iStream);

        start = false;
        for (long i = 0; i < this.checkpoint.getCount(); ++i) {
            JsonParser.Event event = parser.next();
            if (event == JsonParser.Event.START_ARRAY) {
                start = true;
            }
        }
    }

    @Override
    public void close() throws Exception {
         parser.close();
    }

    @Override
    public Object readItem() throws Exception {
               boolean itemFound = false;
        InputTweet item = new InputTweet();
        
        System.out.println("Read Item");

        while (itemFound == false
                && parser.hasNext() == true) {
            JsonParser.Event event = parser.next();
            checkpoint.eventHappened();

            switch (event) {
                case START_ARRAY:
                    start = true;
                    break;
                case VALUE_STRING:
                    if (start == true) {
                        if (item.username == null) {
                            item.username = parser.getString();
                            System.out.println("USERNAME " + item.username);
                        } else if (item.content == null) {
                            item.content = parser.getString();
                            System.out.println("CONTENT " + item.content);
                            itemFound = true;
                        }
                    }
                    break;
                case END_ARRAY:
                    item = null;
                    break;
            }
        }
        return item;
    }

    @Override
    public Serializable checkpointInfo() throws Exception {
         return new Checkpoint();
    }

}
