package com.luteflex.microservices.auth.rabbitmq;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Channel;

import java.nio.charset.StandardCharsets;

public class Sender {

    //private final static String QUEUE_NAME = "Returned_token";


   // public static void main(String[] argv) throws Exception {




    //}

    public void returnToken(String token, String QUEUE_NAME) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        try (Connection connection = factory.newConnection();
             Channel channel = connection.createChannel()) {
            channel.queueDeclare(QUEUE_NAME, false, false, false, null);
            channel.basicPublish("", QUEUE_NAME, null, token.getBytes(StandardCharsets.UTF_8));
            System.out.println(" [x] Sent '" + token + "'");
        }
    }
}
