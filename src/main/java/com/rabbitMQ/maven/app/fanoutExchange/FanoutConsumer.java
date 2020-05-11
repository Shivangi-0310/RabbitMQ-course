package com.rabbitMQ.maven.app.fanoutExchange;

import com.rabbitMQ.maven.app.fragment.Fragment;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DeliverCallback;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class FanoutConsumer {
    public static void main(String[] args) throws IOException, TimeoutException {
        Channel channel = Fragment.createCommonObject();
        DeliverCallback deliverCallback = (consumer, delivery) -> {
            String message = new String(delivery.getBody());
            System.out.println("message received = " + message);
        };
        channel.basicConsume("phone", true, deliverCallback, consumerTag -> {
        });
    }
}
