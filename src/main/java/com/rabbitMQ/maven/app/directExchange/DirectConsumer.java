package com.rabbitMQ.maven.app.directExchange;

import com.rabbitMQ.maven.app.fragment.Fragment;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DeliverCallback;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

// Consumers only work with queue (names) not with exchanges and routing keys

public class DirectConsumer {
    public static void main(String[] args) throws IOException, TimeoutException {
        Channel channel = Fragment.createCommonObject();
        DeliverCallback deliverCallback = (consumer, delivery)->{
            String message = new String(delivery.getBody());
            System.out.println("message received = "+message);
        };
        channel.basicConsume("Email", true, deliverCallback, consumerTag -> {});
    }
}
