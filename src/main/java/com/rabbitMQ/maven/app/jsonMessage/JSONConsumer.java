package com.rabbitMQ.maven.app.jsonMessage;

import com.rabbitMQ.maven.app.fragment.Fragment;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DeliverCallback;
import org.json.JSONObject;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class JSONConsumer {
    public static void main(String[] args) throws IOException, TimeoutException {
        Channel channel = Fragment.createCommonObject();
        DeliverCallback deliverCallback = (consumer, delivery)->{
            System.out.println("entered loop::::::::::::");
            System.out.println("consumer:::  "+consumer+ " ....... "+ delivery.toString());
            String message = new String(delivery.getBody());
            System.out.println("After conversion::::::::::  "+message);
            System.out.println("message received = "+message);
        };
        System.out.println("out of loop............");
        channel.basicConsume("queue-first", true, deliverCallback, consumerTag -> {});
        System.out.println("consumed............");


    }
}
