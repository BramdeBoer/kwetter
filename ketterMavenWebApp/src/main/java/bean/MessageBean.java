package bean;

import service.TweetService;
import service.UserService;

import javax.inject.Inject;
import javax.jms.Message;
import javax.ejb.*;
import javax.jms.*;
import java.io.IOException;

@MessageDriven(
        activationConfig = {
                @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "jms/queue/incoming"),
                @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
                @ActivationConfigProperty(propertyName = "destination", propertyValue = "incoming"),
                @ActivationConfigProperty(propertyName = "resourceAdapter", propertyValue = "activemq-rar-5.14.4")
        }
)
public class MessageBean implements MessageListener {


    @Inject
    TweetService tweetService;

    @Inject
    UserService userService;

    public void onMessage(Message message) {
        try {
            String messageBody = ((TextMessage)message).getText();
            String content = messageBody.split(";")[0];
            String username = messageBody.split(";")[1];

            tweetService.create(content, userService.getUserByUsername(username));
            System.out.println("Tweet created");
        } catch (JMSException e) {
            e.printStackTrace();
        }

    }
}

