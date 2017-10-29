package services;

import constants.Constants;

import javax.annotation.Resource;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.jms.JMSContext;
import javax.jms.Queue;

@ApplicationScoped
public class Sender {
    @Inject
    private JMSContext context;

    @Resource (mappedName = Constants.QUEUE)
    private Queue queue;

    public void send(String text) {
        context.createProducer().send(queue, text);
    }
}
