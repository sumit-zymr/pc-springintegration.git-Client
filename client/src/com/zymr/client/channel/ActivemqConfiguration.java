package com.zymr.client.channel;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
import org.springframework.integration.MessageChannel;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.stereotype.Component;

@Component
public class ActivemqConfiguration {

    @Bean
    public ActiveMQConnectionFactory connectionFactory() {
        ActiveMQConnectionFactory activeMQConnectionFactory =
                new ActiveMQConnectionFactory();
        activeMQConnectionFactory.setBrokerURL("tcp://localhost:61616");
        return activeMQConnectionFactory;
    }

    @Bean
    public ActiveMQQueue userqueue() {
        ActiveMQQueue activeMQQueue = new ActiveMQQueue("user.queue");
        return activeMQQueue;
    }

    @Bean
    public ActiveMQTopic ticketTopic() {
        ActiveMQTopic activeMQTopic = new ActiveMQTopic("user.topic");
        return activeMQTopic;
    }

    @Bean
    public MessageChannel ticketChannel() {
        MessageChannel channel = new DirectChannel();
        return channel;
    }
}
