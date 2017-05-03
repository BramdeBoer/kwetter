/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package topic;

import java.util.Properties;
import java.util.concurrent.CountDownLatch;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jms.ConnectionFactory;
import javax.jms.JMSConsumer;
import javax.jms.JMSContext;
import javax.jms.JMSProducer;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.Topic;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 * @author jgeenen
 */
public class TopicHelloWorld {

    private static final Logger LOG = Logger.getLogger(TopicHelloWorld.class.getName());
    /**
     * the preconfigured GlassFish-default connection factory
     */
    private static final String JNDI_CONNECTION_FACTORY = "jms/__defaultConnectionFactory";
    /**
     * the JNDI name under which your {@link Topic} should be: you have to
     * create the topic before running this class
     */
    private static final String JNDI_TOPIC = "jms/KwetterGo/topic";



    /**
     * @param <T> the return type
     * @param retvalClass the returned value's {@link Class}
     * @param jndi the JNDI path to the resource
     * @return the resource at the specified {@code jndi} path
     */
    private static <T> T lookup(Class<T> retvalClass, String jndi) {
        try {
            return retvalClass.cast(InitialContext.doLookup(jndi));
        } catch (NamingException ex) {
            throw new IllegalArgumentException("failed to lookup instance of " + retvalClass + " at " + jndi, ex);
        }
    }

    /**
     * Send a {@link javax.jms.TextMessage} to the
     * {@link Topic}@{@value #JNDI_TOPIC} using the
     * {@link ConnectionFactory}@{@value #JNDI_CONNECTION_FACTORY}. The message
     * is received, after which the method exits.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) throws NamingException {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        Properties props = new Properties();

        props.put ("java.naming.factory.initial","com.sun.enterprise.naming.impl.SerialInitContextFactory");

        InitialContext initialContext;
            initialContext = new InitialContext(props);

        final ConnectionFactory connectionFactory = (ConnectionFactory) lookup(ConnectionFactory.class, JNDI_CONNECTION_FACTORY);

        
        final Topic topic = lookup(Topic.class, JNDI_TOPIC);
        //JMSContext implements AutoClosable: let us try 'try-with-resources'
        //see http://docs.oracle.com/javase/tutorial/essential/exceptions/tryResourceClose.html
        try (JMSContext jmsContext = connectionFactory.createContext()) {
            final JMSConsumer topicConsumer = jmsContext.createConsumer(topic);
            final MessageListener messageListener = new MessageListener() {
                @Override
                public void onMessage(Message message) {
                    LOG.log(Level.INFO, "received {0}", message);
                    countDownLatch.countDown();
                }
            };
            topicConsumer.setMessageListener(messageListener);
            final JMSProducer producer = jmsContext.createProducer();
            final String text = "hello world!";
            producer.send(topic, text);
            LOG.log(Level.INFO, "sent {0} to {1}", new Object[]{text, JNDI_TOPIC});
            try {
                countDownLatch.await();
                LOG.log(Level.INFO, "phew... it worked", text);
            } catch (InterruptedException ex) {
                LOG.log(Level.SEVERE, "fatal error: ", ex);
            }
        }//jmsContext is autoclosed
    }
}
