package com.rabbitMQ.maven.app.fanoutExchange;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class FanoutPublisher {
    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        System.out.println("entered connection factory::: " + connectionFactory.toString());
        connectionFactory.setHost("localhost");
        Connection connection = connectionFactory.newConnection();
        System.out.println("connection:::: " + connection.toString());
        Channel channel = connection.createChannel();

        System.out.println("channel:::: " + channel.toString());

        String message = "Fanout for 2 email, phone";
        channel.basicPublish("fanout.exchange", "", null, message.getBytes());
        System.out.println("Message published");
        channel.close();
        connection.close();
    }
}
