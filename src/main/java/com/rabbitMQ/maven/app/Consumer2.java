package com.rabbitMQ.maven.app;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

//For creating multiple consumers.

public class Consumer2 {
    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.newConnection();
        Channel channel = connection.createChannel();

        DeliverCallback deliverCallback = (consumer, delivery)->{
            String message = new String(delivery.getBody());
            System.out.println("message received = "+message);
        };
        channel.basicConsume("queue-first", true, deliverCallback, consumerTag -> {});
        

    }
}
