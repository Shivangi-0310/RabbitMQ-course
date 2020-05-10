package com.rabbitMQ.maven.app.jsonMessage;

import com.rabbitMQ.maven.app.fragment.Fragment;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.json.JSONObject;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class JSONPublisher {
    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        System.out.println("entered connection factory::: "+connectionFactory.toString());
        connectionFactory.setHost("localhost");
        Connection connection = connectionFactory.newConnection();
        System.out.println("connection:::: "+connection.toString());
        Channel channel = connection.createChannel();
        channel.queueDeclare("queue-first", false,false,false,null);

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("from_date","10-July-2019");
        jsonObject.put("to_date","03-August-2019");
        jsonObject.put("email","xyz@gmail.com");
        jsonObject.put("queryString","select * from data");

        channel.basicPublish("", "queue-first", null, jsonObject.toString().getBytes());
        System.out.println("Message published");
        channel.close();
        connection.close();
    }
}
