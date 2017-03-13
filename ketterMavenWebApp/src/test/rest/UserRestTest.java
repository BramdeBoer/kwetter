package rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import junit.framework.TestCase;
import model.User;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;
import util.DatabaseCleaner;

import javax.persistence.Persistence;
import java.util.List;

/**
 * Created by bramd on 13-3-2017.
 */
public class UserRestTest extends TestCase {

    ObjectMapper mapper;

    public void setUp() throws Exception {
        super.setUp();
        mapper = new ObjectMapper();

        HttpUriRequest request;

        request = new HttpPost("http://localhost:8080/kwetter/API/users/username1/name1");
        HttpClientBuilder.create().build().execute(request);


        request = new HttpPost("http://localhost:8080/kwetter/API/users/username2/name2");
        HttpClientBuilder.create().build().execute(request);
    }

    public void tearDown() throws Exception {
        DatabaseCleaner databaseCleaner = new DatabaseCleaner(Persistence.createEntityManagerFactory("KwetterPU").createEntityManager());
        databaseCleaner.clean();
    }

    public void testGetUsers() throws Exception {
        HttpUriRequest request = new HttpGet("http://localhost:8080/kwetter/API/users/");
        HttpResponse  httpResponse = HttpClientBuilder.create().build().execute(request);

        List<User> resource = mapper.readValue(httpResponse.getEntity().getContent(), TypeFactory.defaultInstance().constructCollectionType(List.class, User.class));

        assertEquals(2, resource.size());
    }

    public void testGetUserByUsername() throws Exception {
        HttpUriRequest request = new HttpGet("http://localhost:8080/kwetter/API/users/username1");
        HttpResponse  httpResponse = HttpClientBuilder.create().build().execute(request);

        User resource = mapper.readValue(httpResponse.getEntity().getContent(), User.class);

        assertEquals("username1", resource.getUsername());
    }

    public void testGetRecentTweets() throws Exception {
        
    }

    public void testGetFollowers() throws Exception {

    }

    public void testGetFollowing() throws Exception {

    }

    public void testGetTimelineTweets() throws Exception {

    }

}