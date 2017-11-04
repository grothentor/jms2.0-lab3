package services;

import constants.Constants;

import javax.annotation.Resource;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.jms.*;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class Receiver {
    @Inject
    private JMSContext context;

    @Resource(mappedName = Constants.QUEUE)
    private Queue queue;

    private List<String> messages;

    public Receiver() {
        messages = new ArrayList<>();
        messages.add("Refresh page for receive new messages");
    }

    public boolean receive() {
        JMSConsumer consumer = context.createConsumer(queue);
        Message newMessage = consumer.receiveNoWait();
        if (null != newMessage) {
            try {
                messages.add(newMessage.getBody(String.class));
            } catch (JMSException exception) {
                messages.add(exception.getMessage());
            }
            return true;
        }
        return false;
    }

    public List<String> getMessages() {
        return this.messages;
    }
}
