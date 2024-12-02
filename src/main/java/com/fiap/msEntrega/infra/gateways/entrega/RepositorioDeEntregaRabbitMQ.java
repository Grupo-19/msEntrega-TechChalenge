package com.fiap.msEntrega.infra.gateways.entrega;

import com.fiap.msEntrega.config.RabbitConfig;
import com.fiap.msEntrega.domain.entrega.Entrega;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
public class RepositorioDeEntregaRabbitMQ {

    private final RabbitTemplate rabbitTemplate;

    public RepositorioDeEntregaRabbitMQ(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void atualizarStatus(Entrega entrega) {
        try {
            rabbitTemplate.convertAndSend(RabbitConfig.FILA_ENTREGAS, entrega);
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
