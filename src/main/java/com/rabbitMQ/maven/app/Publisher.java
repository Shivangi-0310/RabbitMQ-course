package com.rabbitMQ.maven.app;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Publisher {
    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        System.out.println("entered connection factory::: "+connectionFactory.toString());
        connectionFactory.setHost("localhost");
        Connection connection = connectionFactory.newConnection();
        System.out.println("connection:::: "+connection.toString());
        Channel channel = connection.createChannel();
        channel.queueDeclare("queue-first", false,false,false,null);

        System.out.println("channel:::: "+channel.toString());

        String message = "first RabbitMQ message";
        channel.basicPublish("", "queue-first", null, message.getBytes());
        System.out.println("Message published");
        channel.close();
        connection.close();
    }
    
}
