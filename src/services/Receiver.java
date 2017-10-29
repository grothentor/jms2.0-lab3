package services;

import constants.Constants;

import javax.annotation.Resource;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.jms.JMSConsumer;
import javax.jms.JMSContext;
import javax.jms.Queue;

@ApplicationScoped
public class Receiver {
    @Inject
    private JMSContext context;

    @Resource(mappedName = Constants.QUEUE)
    private Queue queue;

    public String receive() {
        JMSConsumer consumer = context.createConsumer(queue);
        return consumer.receiveBody(String.class);
    }
}
