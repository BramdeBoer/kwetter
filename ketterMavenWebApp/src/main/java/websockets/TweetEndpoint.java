package websockets;
import com.fasterxml.jackson.databind.ObjectMapper;
import dto.TweetDTO;
import model.Tweet;
import service.TweetService;
import service.UserService;

import javax.inject.Inject;
import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

@ServerEndpoint(value = "/tweetsocket")
public class TweetEndpoint {

    @Inject
    private TweetService tweetService;
    @Inject
    private UserService userService;

    private static final Logger LOG = Logger.getLogger(TweetEndpoint.class.getName());
    private static final Set<Session> peers = Collections.synchronizedSet(new HashSet<Session>());

    @OnOpen
    public void onOpen(Session peer) {
        LOG.info("Connection opened ...");
        peers.add(peer);
    }

    @OnClose
    public void onClose(Session peer) {
        LOG.info("Connection closed ...");
        peers.remove(peer);
    }

    @OnError
    public void onError(Throwable t) {
        LOG.log(Level.INFO, "Error ...{0}", t.getMessage());
    }

    @OnMessage
    public void onMessage(final Session client, final String message) {
        if (message != null) {
            Tweet newTweet = tweetService.create(message, userService.getUserByUsername("bramdb"));
            TweetDTO jsonTweet = new TweetDTO(newTweet);
            sendMessage(client, jsonTweet);
        }
    }

    private void sendMessage(Session peer, Object send) {
        try {
            if (peer.isOpen()) {
                ObjectMapper mapper = new ObjectMapper();
                peer.getBasicRemote().sendObject(mapper.writeValueAsString(send));
            }
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, null, ex);
        }
    }

    private void sentToAll(Object answer) {
        for (Iterator<Session> it = peers.iterator(); it.hasNext();) {
            sendMessage(it.next(), answer);
        }
    }
}