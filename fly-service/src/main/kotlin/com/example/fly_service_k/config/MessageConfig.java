package com.example.destiny_service.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;


public class MessageConfig {
    @Bean
    public Queue queue() {
        return new Queue(constants.QUEUE);
    }


    @Bean
    public TopicExchange exchange() {
        return new TopicExchange(constants.EXCHANGE);
    }


    @Bean
    public Binding binding(Queue queue, TopicExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(constants.ROUTING_KEY);
    }


    @Bean
    public MessageConverter converter() {
        return new Jackson2JsonMessageConverter();
    }


    @Bean
    public AmqpTemplate template(ConnectionFactory connectionFactory) {
        final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(converter());
        return rabbitTemplate;
    }
}
