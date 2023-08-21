package com.onurgundogdu.orderintegration.configuration;

import com.onurgundogdu.orderintegration.model.Order;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.messaging.MessageChannel;

@Configuration
public class OrderConfiguration {

    @Bean
    public MessageChannel orderChannel(){
        return new DirectChannel();
    }

    @MessagingGateway
    public interface OrderGateway {
        @Gateway(requestChannel = "orderChannel")
        void processOrder(Order order);
    }
}
