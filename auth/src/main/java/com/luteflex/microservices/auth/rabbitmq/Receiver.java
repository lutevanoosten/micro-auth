package com.luteflex.microservices.auth.rabbitmq;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.luteflex.microservices.auth.AuthConfiguration;
import com.luteflex.microservices.auth.Models.TokenRequest;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;


public class Receiver {

    private final static String QUEUE_NAME = "Request_token";

    private static AuthConfiguration authConfiguration = new AuthConfiguration();


    public static void main(String[] argv) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        System.out.println(" [*] Waiting for messages. To exit press CTRL+C");

        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
            String message = new String(delivery.getBody(), "UTF-8");
            System.out.println(" [x] Received request'" + message + "'");
            TokenRequest tokenRequest = new ObjectMapper().readValue(message, TokenRequest.class);
            try {
                authConfiguration.createJWT(tokenRequest);
            } catch (Exception e) {
                e.printStackTrace();
            }
        };
        channel.basicConsume(QUEUE_NAME, true, deliverCallback, consumerTag -> { });
    }

}