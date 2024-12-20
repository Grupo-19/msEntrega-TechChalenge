package com.fiap.msEntrega.config;

import com.fiap.msEntrega.infra.gateways.entrega.RepositorioDeEntregaRabbitMQ;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

    public static final String FILA_ENTREGAS = "entregasQueue";

    @Bean
    public Queue pedidosQueue() {
        return new Queue(FILA_ENTREGAS, true);
    }

    @Bean
    public Jackson2JsonMessageConverter jackson2JsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory,
                                         Jackson2JsonMessageConverter converter) {
        RabbitTemplate template = new RabbitTemplate(connectionFactory);
        template.setMessageConverter(converter);
        return template;
    }

    @Bean
    RepositorioDeEntregaRabbitMQ repositorioDeEntregaRabbitMQ(RabbitTemplate rabbitTemplate){
        return new RepositorioDeEntregaRabbitMQ(rabbitTemplate);
    }

}
