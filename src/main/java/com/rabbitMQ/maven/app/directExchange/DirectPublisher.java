package com.rabbitMQ.maven.app.directExchange;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

// Publishers work with with exchanges and routing keys in case of direct-exchange.


public class DirectPublisher {
    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.newConnection();
        Channel channel = connection.createChannel();
        String message = "This exchange is for email";

        channel.basicPublish("direct.exchange", "phone", null, message.getBytes());

        channel.close();
        connection.close();
    }
}
